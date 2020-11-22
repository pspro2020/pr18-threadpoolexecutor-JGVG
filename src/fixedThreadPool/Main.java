package fixedThreadPool;

public class Main {
    public static void main(String[] args) {

        ExecutorClass executor = new ExecutorClass();

        for( int i = 0; i <= 10; i++){
            Task task = new Task("Tarea "+ i, i);
            executor.execute(task);
        }
        try {
            executor.shutdown();
        } catch (InterruptedException e) {
            return;
        }

    }

}

