package oncall.calendar;

import oncall.io.date.DateSetting;
import oncall.io.date.DayOfWeek;

public class Calendar {
    private static final int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private final int month;
    private final boolean[] isHoliday;
    private final DayOfWeek[] dayOfWeeks;

    public Calendar(DateSetting dateSetting) {
        this.month = dateSetting.getMonth();
        isHoliday = new boolean[days[month] + 1];
        this.dayOfWeeks = new DayOfWeek[days[month] + 1];

        int added = dateSetting.getDayOfWeek().getId() - 1;
        for (int i = 1; i < isHoliday.length; i++) {
            dayOfWeeks[i] = DayOfWeek.getDayOfWeek(i + added);
            if(dayOfWeeks[i].equals(DayOfWeek.토)
                    || dayOfWeeks[i].equals(DayOfWeek.일)
                    || LegalHoliday.getHoliday(month).contains(i))
                isHoliday[i] = true;
        }
    }

    public boolean isHoliday(int day) {
        return isHoliday[day];
    }

    public Date getDate(int day) {
        return new Date(month, day, dayOfWeeks[day], isHoliday[day]);
    }
}
