package com.company;

import java.util.concurrent.Callable;

public class PrinterTask extends Thread implements Callable<PrinterTaskInfo> {

    private PrinterTaskInfo printerTaskInfo;

    public PrinterTask(PrinterTaskInfo taskInfo) {
        super(taskInfo.getTaskName());
        this.printerTaskInfo = taskInfo;
    }

    @Override
    public PrinterTaskInfo call () throws Exception {
        int i = 0;
        while (true) {
            i++;
            double random = Math.random();
            System.out.println("Message from " + getName() + " task's execution thread(" + Thread.currentThread().getName()
                    + "): randomValue = " + random);
            if (random > 0.5) {
                printerTaskInfo.setTaskExecutionResult(i);
                break;
            }
            Thread.sleep(2500);
        }
        return printerTaskInfo;
    }

}