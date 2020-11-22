package cachedThreadPool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Task  implements Runnable{
    private final int num_table;
    private final String task_name;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Task(String task_name, int num_table){
        this.task_name = task_name;
        this.num_table = num_table;
    }

    @Override
    public void run() {

        for(int j = 0; j<=10; j++){
            try {
                work();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s -> %s -> %s "+Thread.currentThread().getName()+": "+ num_table +"^"+j+" = "+ (int)Math.pow(num_table,j)+"\n", Thread.currentThread().getName(), task_name, dateTimeFormatter.format(LocalDateTime.now()));
        }
    }

    private void work() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(200);
    }
}
