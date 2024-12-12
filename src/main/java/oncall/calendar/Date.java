package oncall.calendar;

import oncall.io.date.DayOfWeek;

public class Date {
    private final int month;
    private final int day;
    private final DayOfWeek dayOfWeek;
    private final boolean isHoliday;

    public Date(int month, int day, DayOfWeek dayOfWeek, boolean isHoliday) {
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.isHoliday = isHoliday;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public boolean isHoliday() {
        return isHoliday;
    }
}
