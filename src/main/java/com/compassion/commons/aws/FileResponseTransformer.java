package com.compassion.commons.aws;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.core.exception.RetryableException;
import software.amazon.awssdk.core.internal.http.InterruptMonitor;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.http.AbortableInputStream;
import software.amazon.awssdk.utils.Logger;

/**
 * Extend the path response transformer built into the AWS SDK with {@link CopyOption}.
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class FileResponseTransformer<T> implements ResponseTransformer<T, T> {
	private final Path path;
	private final CopyOption[] options;
	
	public static <T> FileResponseTransformer<T> withPath(Path path, CopyOption... options) {
		return new FileResponseTransformer<>(path, options);
	}
	
	@Override
	public T transform(T response, AbortableInputStream in) throws Exception {
        try {
            InterruptMonitor.checkInterrupted();
            Files.copy(in, path, options); // ONLY CHANGE from original class
            return response;
        } catch (IOException copyException) {
            String copyError = "Failed to read response into file: " + path;

            // If the write failed because of the state of the file, don't retry the request.
            if (copyException instanceof FileAlreadyExistsException || copyException instanceof DirectoryNotEmptyException) {
                throw new IOException(copyError, copyException);
            }

            // Try to clean up the file so that we can retry the request. If we can't delete it, don't retry the request.
            try {
                Files.deleteIfExists(path);
            } catch (IOException deletionException) {
                Logger.loggerFor(ResponseTransformer.class)
                      .error(() -> "Failed to delete destination file '" + path +
                                   "' after reading the service response " +
                                   "failed.", deletionException);

                throw new IOException(copyError + ". Additionally, the file could not be cleaned up (" +
                                      deletionException.getMessage() + "), so the request will not be retried.",
                                      copyException);
            }

            // Retry the request
            throw RetryableException.builder().message(copyError).cause(copyException).build();
        }
	}
}
