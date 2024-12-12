package oncall.work;

import oncall.io.work.WorkOrderSetting;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WorkerList {
    private final List<String> weekdayWorker;
    private final List<String> holidayWorker;
    private Queue<String> weekdayWorkerRotation;
    private Queue<String> holidayWorkerRotation;

    private String currentWorkerName;

    public WorkerList(WorkOrderSetting workOrderSetting) {
        this.weekdayWorker = workOrderSetting.getWeekday();
        this.holidayWorker = workOrderSetting.getHoliday();

        weekdayWorkerRotation = new LinkedList<>(weekdayWorker);
        holidayWorkerRotation = new LinkedList<>(holidayWorker);
    }

    public String findWeekDayWorker() {
        fillWeekdayWorkerRotation();
        if(isTwoConsecutiveWork(weekdayWorkerRotation))
            weekdayWorkerRotation = swap(weekdayWorkerRotation);

        currentWorkerName = weekdayWorkerRotation.poll();
        return currentWorkerName;
    }

    public String findHolidayWorker() {
        fillHolidayWorkerRotation();
        if(isTwoConsecutiveWork(holidayWorkerRotation))
            holidayWorkerRotation = swap(holidayWorkerRotation);

        currentWorkerName = holidayWorkerRotation.poll();
        return currentWorkerName;
    }

    private Queue<String> swap(Queue<String> rotation) {
        String str1 = rotation.poll();
        String str2 = rotation.poll();

        Queue<String> result = new LinkedList<>();
        result.add(str2);
        result.add(str1);
        result.addAll(rotation);
        return result;
    }

    private boolean isTwoConsecutiveWork(Queue<String> rotation) {
        return rotation.peek().equals(currentWorkerName);
    }

    private void fillHolidayWorkerRotation() {
        if(holidayWorkerRotation.size() < 2)
            holidayWorkerRotation.addAll(holidayWorker);
    }

    private void fillWeekdayWorkerRotation() {
        if(weekdayWorkerRotation.size() < 2)
            weekdayWorkerRotation.addAll(weekdayWorker);
    }

}
