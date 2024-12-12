package oncall.calendar;

import oncall.io.date.DayOfWeek;

public class Date {
    private final int month;
    private final int day;
    private final DayOfWeek dayOfWeek;
    private final boolean isLegalHoliday;

    public Date(int month, int day, DayOfWeek dayOfWeek, boolean isLegalHoliday) {
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.isLegalHoliday = isLegalHoliday;
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
        return dayOfWeek.isHoliday();
    }

    public boolean isLegalHoliday() {
        return isLegalHoliday;
    }
}
