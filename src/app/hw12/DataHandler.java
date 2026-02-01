package app.hw12;


import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.currentThread;

public class DataHandler {

    String[] fruits = new DataRepository().getData();

    public void getOutput() {
        // critical
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            AtomicInteger count = new AtomicInteger(1);
            for (String fruit : fruits) {
                sb.append(String.format("(%d) %s ",
                        count.getAndAdd(1), fruit));
            }
            System.out.println(currentThread().getName() + ": " + sb);
        }
    }
}