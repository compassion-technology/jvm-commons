/*
 * Copyright Terracotta, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ehcache.impl.internal.store.disk;

import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.ehcache.core.spi.service.ExecutionService;
import org.ehcache.shadow.org.terracotta.offheapstore.util.Factory;
import org.jooq.lambda.Seq;

import com.compassion.commons.Utilities;

import lombok.val;

/**
 * Copied from source to fix memory leak- see below
 * @author jdimeo
 */
public class DiskWriteThreadPool implements Factory<ExecutorService> {
	private static final Set<BlockingQueue<Runnable>> queues = new CopyOnWriteArraySet<>();
	
  private final List<ExecutorService> writers = new CopyOnWriteArrayList<>();
  private final ExecutionService executionService;
  private final String poolAlias;
  private final int threads;

  private int index   = 0;

  public DiskWriteThreadPool(ExecutionService executionService, String poolAlias, int threads) {
    this.executionService = executionService;
    this.poolAlias = poolAlias;
    this.threads = threads;
  }

  @Override
  public ExecutorService newInstance() {
    ExecutorService writer;
    if (writers.size() < threads) {
    // TODO: If this is left unbounded (originally `new LinkedBlockingQueue<>()`),
    // it will saturate all RAM with unwritten bytes!!
    // See: https://stackoverflow.com/questions/59777140/
    	val queue = new LinkedBlockingQueue<Runnable>(100);
    	queues.add(queue);
      writer = executionService.getOrderedExecutor(poolAlias, queue);
      writers.add(writer);
    } else {
      writer = writers.get(index++);
      if (index == writers.size()) {
        index = 0;
      }
    }
    return writer;
  }
  
  public static void waitForDiskWrites() {
	  while (!Seq.seq(queues).allMatch(BlockingQueue::isEmpty)) {
		  Utilities.sleep(10L, TimeUnit.MILLISECONDS);
	  }
  }
}
