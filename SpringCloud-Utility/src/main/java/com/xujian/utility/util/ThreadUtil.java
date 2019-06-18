package com.xujian.utility.util;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池管理, SpringBoot自带异步执行，不需要了
 */
@Deprecated
public class ThreadUtil {
    private static ThreadUtil ThreadUtil;
    private ExecutorService executor;
    private ExecutorService cacheExecutor;
    private ExecutorService singleExecutor;
    private ScheduledExecutorService scheduleExecutor;

    private ThreadUtil() {
    }

    public synchronized static ThreadUtil getInstance() {
        if (ThreadUtil == null) {
            ThreadUtil = new ThreadUtil();
        }
        return ThreadUtil;
    }

    public ExecutorService getExecutor(int threadCount) {
        if (executor == null) {
            executor = Executors.newFixedThreadPool(threadCount);
        }
        return executor;
    }

    public ExecutorService getCacheExecutor() {
        if (cacheExecutor == null) {
            cacheExecutor = Executors.newCachedThreadPool();
        }
        return cacheExecutor;
    }

    public ExecutorService getSingleExecutor() {
        if (singleExecutor == null) {
            singleExecutor = Executors.newSingleThreadExecutor();
        }
        return singleExecutor;
    }

    public ScheduledExecutorService getScheduleExecutor(int threadCount) {
        if (scheduleExecutor == null) {
            scheduleExecutor = Executors.newScheduledThreadPool(threadCount);
        }
        return scheduleExecutor;
    }

    public void execute(Runnable task) {
        if (executor == null) {
            executor = Executors.newCachedThreadPool();
        }
        executor.execute(task);
    }

    public Future submit(Runnable task) {
        return executor.submit(task);
    }

    public void reset() {
        executor = null;
        cacheExecutor = null;
        scheduleExecutor = null;
    }

    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "ThreadUtils #" + mCount.getAndIncrement());
        }
    };

    private static final BlockingQueue<Runnable> sPoolWorkQueue =
            new LinkedBlockingQueue<Runnable>(Integer.MAX_VALUE / 2);

    /**
     * An {@link Executor} that can be used to execute tasks in parallel.
     */
    public static final ThreadPoolExecutor THREAD_POOL_EXECUTOR
            = new ThreadPoolExecutor(1, 4, 1, TimeUnit.MINUTES, sPoolWorkQueue, sThreadFactory);
}