package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<PrinterTask> listTask2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            listTask2.add(new PrinterTask(new PrinterTaskInfo("PrinterTask-" + i)));
        }
        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Future<PrinterTaskInfo>> executedTasksResults = executor.invokeAll(listTask2);

        for (Future<PrinterTaskInfo> printTaskExecutionResult: executedTasksResults) {
            PrinterTaskInfo printerTaskInfo = printTaskExecutionResult.get();
            System.out.println("Result of the " + printerTaskInfo.getTaskName() + " execution is equal to "
                    + printerTaskInfo.getTaskExecutionResult());
        }
        executor.shutdown();
    }

}
