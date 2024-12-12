package oncall;

import oncall.calendar.Calendar;
import oncall.io.date.DateSetting;
import oncall.io.date.DateSettingReader;
import oncall.io.work.WorkOrderSetting;
import oncall.io.work.WorkOrderSettingReader;
import oncall.work.WorkBoard;
import oncall.work.Worker;
import oncall.work.WorkerList;
import oncall.work.WorkerListFormatter;

import java.util.LinkedList;
import java.util.List;

public class MyWorkerApp {
    private final WorkBoard workBoard;
    private final WorkerListFormatter workerListFormatter;

    public MyWorkerApp(WorkBoard workBoard, WorkerListFormatter workerListFormatter) {
        this.workBoard = workBoard;
        this.workerListFormatter = workerListFormatter;
    }

    public void run() {
        List<Worker> workers = new LinkedList<>();
        while (workBoard.hasMoreWork()) {
            workers.add(workBoard.next());
        }
        System.out.println(workerListFormatter.formatted(workers));
    }
}
