package fixedThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorClass {
    private final ThreadPoolExecutor fixedThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

    void execute(Task task) {
        try {
            fixedThreadPool.execute(task);
        } catch (Exception e) {
           return;
        }
    }

    void shutdown() throws InterruptedException {
        fixedThreadPool.shutdown();
        if (fixedThreadPool.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.printf("Tareas terminadas: %d\n",
                    fixedThreadPool.getCompletedTaskCount());
        } else {
            System.out.printf("Tareas no terminadas: %d\n",
                    fixedThreadPool.getCompletedTaskCount());
        }
    }
}
