package cachedThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorClass {
    private final ThreadPoolExecutor cachedThreadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();

    void execute(Task task) {
        try {
            cachedThreadPool.execute(task);
        } catch (Exception e) {
           return;
        }
    }

    void shutdown() throws InterruptedException {
        cachedThreadPool.shutdown();
        if (cachedThreadPool.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.printf("Tareas terminadas: %d\n",
                    cachedThreadPool.getCompletedTaskCount());
        } else {
            System.out.printf("Tareas no terminadas: %d\n",
                    cachedThreadPool.getCompletedTaskCount());
        }
    }
}
