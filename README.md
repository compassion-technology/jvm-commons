ERI Commons - Language Extensions
------------------------------------------

This project adds to the language extensions and utilities provided by Apache Commons.

Currently in this project:

- `DateExtractor`: General-purpose/robust date parser/extractor that uses all ~500 localized date formats available to the JVM. 
- `JaroWinklerDistance`: Computes the distance between two strings (by Bob Carpenter, lifted from LingPipe)
- `ReflectionUtils`: Wrapper around the Java reflection APIs, simplifying their use and absorbing exceptions.
- `RuntimeExec`: Wrapper around `Runtime.exec` that consumes the output and error streams. This helps with known limitations/difficulties of using Java to invoke external commands (see [http://www.javaworld.com/article/2071275/core-java/when-runtime-exec---won-t.html](http://www.javaworld.com/article/2071275/core-java/when-runtime-exec---won-t.html))
- `StatusMonitor`/`StatusListener`: "Transactional" status API for long-running tasks.  You can set the task state, progress, or message in atomic operations continually, but listeners will only be notified at fixed time intervals (or when certain state changes regardless of time). You can poll a status monitor to know if the user canceled the task.
- `StopWatch`: Enhanced/improved version of Apache's stop watch functionality
- `StringMatcher`: Utility for programmatically matching strings using starts with, ends with, contains, equals, regular expressions, and ignore case.
- `UnicodeChars`: Constant declarations of some commonly used unicode characters, like box drawing, the copyright sign, ellipsis, infinity, etc. 
- `Utilities`: A grab-bag of static utilities. Please move them out of this class if they have a better home or are duplicate of some functionality available in a third-party library.

This project transitively sends Apache Commons 3 and ERI's logging (`LogContext`) to its dependents.