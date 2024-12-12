package oncall;

import oncall.calendar.Calendar;
import oncall.io.InputReader;
import oncall.io.date.DateSettingReader;
import oncall.io.retry.DateSettingReaderRetryAspect;
import oncall.io.retry.WorkOrderSettingReaderRetryAspect;
import oncall.io.work.WorkOrderSettingReader;
import oncall.work.WorkBoard;
import oncall.work.WorkerList;
import oncall.work.WorkerListFormatter;

public class Application {
    public static void main(String[] args) {
        Calendar calendar = getCalendar(dateSettingReader());
        WorkerList workerList = workerList(workOrderSettingReader());
        WorkBoard workBoard = workBoard(calendar, workerList);
        MyWorkerApp app = new MyWorkerApp(workBoard, workerListFormatter());
        app.run();
    }

    private static WorkerListFormatter workerListFormatter() {
        return new WorkerListFormatter();
    }

    private static WorkBoard workBoard(Calendar calendar, WorkerList workerList) {
        return new WorkBoard(calendar, workerList);
    }

    private static WorkerList workerList(WorkOrderSettingReader workOrderSettingReader) {
        return new WorkerList(workOrderSettingReader.read());
    }

    private static Calendar getCalendar(DateSettingReader dateSettingReader) {
        return new Calendar(dateSettingReader.read());
    }

    private static DateSettingReader dateSettingReader() {
        return new DateSettingReaderRetryAspect(new DateSettingReader(inputReader()));
    }

    private static WorkOrderSettingReader workOrderSettingReader() {
        WorkOrderSettingReader workOrderSettingReader = new WorkOrderSettingReaderRetryAspect(new WorkOrderSettingReader(inputReader()));
        return workOrderSettingReader;
    }

    private static InputReader inputReader() {
        InputReader inputReader = new InputReader();
        return inputReader;
    }
}
