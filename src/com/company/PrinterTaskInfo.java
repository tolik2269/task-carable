package com.company;

public class PrinterTaskInfo {

    private String taskName;
    private int taskExecutionResult;

    public PrinterTaskInfo(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskExecutionResult() {
        return taskExecutionResult;
    }

    public void setTaskExecutionResult(int taskExecutionResult) {
        this.taskExecutionResult = taskExecutionResult;
    }
}
