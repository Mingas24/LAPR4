package eapli.base.messagemanagement.application;

import java.io.File;

public class ThreadService {

    public void createThread(String path) throws InterruptedException {
        File file = new File(path);
        String[] list = file.list();
        Thread[] thread = new Thread[list.length];
        int i = 0;
        for (String test : list) {
            ImportService service = new ImportService(test);
            thread[i] = new Thread(service);
            thread[i].start();
            i++;
        }
        waitForThreads(thread);
    }

    private void waitForThreads(Thread[] threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
            System.out.print("The system closed the file.\n");
        }
    }
}
