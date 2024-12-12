package oncall.work;

import oncall.calendar.Calendar;
import oncall.calendar.Date;

public class WorkBoard {
    private final Calendar calendar;
    private final WorkerList workerList;

    private int currentDay;

    public WorkBoard(Calendar calendar, WorkerList workerList) {
        this.calendar = calendar;
        this.workerList = workerList;
        currentDay = 1;
    }

    public Worker next() {
        if(!hasMoreWork())
            return null;

        Date workDate = calendar.getDate(currentDay++);
        if(workDate.isHoliday())
            return new Worker(workDate, workerList.findHolidayWorker());
        return new Worker(workDate, workerList.findWeekDayWorker());
    }

    public boolean hasMoreWork() {
        return currentDay <= calendar.getEndOfMonth();
    }
}
