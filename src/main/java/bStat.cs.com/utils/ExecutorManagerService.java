package bStat.cs.com.utils;

import java.util.concurrent.*;

/**
 * Created by prashant170392 on 01/05/2017
 */
public class ExecutorManagerService {

    private static Executor fixedThreadPoolExecutor = Executors.newFixedThreadPool(100);
    private static Executor fixedPoolExecutor = Executors.newFixedThreadPool(4);
    private static ScheduledExecutorService scheduledThreadPoolExecutor = Executors.newScheduledThreadPool(50);

    public static void executeTask(Runnable task) {
        fixedThreadPoolExecutor.execute(task);
    }

    public static Executor getExecutorForRequestProcessing() {
        return fixedPoolExecutor;
    }

    public static void scheduleTask(Runnable futureTask, long timeDelay) throws Exception {
        try {
            scheduledThreadPoolExecutor.schedule(futureTask, timeDelay, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static ScheduledExecutorService getScheduledThreadPoolExecutor() {
        return scheduledThreadPoolExecutor;
    }

    public static ScheduledFuture<?> scheduleTaskAtFixedRate(Runnable futureTask, long timeDelay, long period) throws Exception {
        try {
            ScheduledFuture<?> scheduledFuture = scheduledThreadPoolExecutor.scheduleAtFixedRate(futureTask, timeDelay, period, TimeUnit.SECONDS);
            return scheduledFuture;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
