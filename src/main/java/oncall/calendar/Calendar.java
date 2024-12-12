package oncall.calendar;

import oncall.io.date.DateSetting;
import oncall.io.date.DayOfWeek;

public class Calendar {
    private static final int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private final int month;
    private final DayOfWeek[] dayOfWeeks;

    public Calendar(DateSetting dateSetting) {
        this.month = dateSetting.getMonth();
        this.dayOfWeeks = new DayOfWeek[days[month] + 1];

        int added = dateSetting.getDayOfWeek().getId() - 1;
        for (int i = 1; i < dayOfWeeks.length; i++) {
            dayOfWeeks[i] = DayOfWeek.getDayOfWeek(i + added);
        }
    }

    public boolean isHoliday(int day) {
        validDay(day);
        return dayOfWeeks[day].isHoliday();
    }

    public Date getDate(int day) {
        validDay(day);
        return new Date(
                month,
                day,
                dayOfWeeks[day],
                LegalHoliday.getHoliday(month).contains(day)
        );
    }

    private void validDay(int day) {
        if(day <= 0 || getEndOfMonth() < day)
            throw new IllegalArgumentException();
    }

    public int getEndOfMonth() {
        return days[month];
    }
}
