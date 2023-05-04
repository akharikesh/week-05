public class TaskRunner {

    @LogExecutionTime
    public void fastTask() {
        for (int i = 0; i < 1000; i++) {
            int x = i * i;
        }
    }

    @LogExecutionTime
    public void slowTask() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
