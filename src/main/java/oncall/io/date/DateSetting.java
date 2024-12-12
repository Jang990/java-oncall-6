package oncall.io.date;

public class DateSetting {
    private final int month;
    private final DayOfWeek dayOfWeek;

    public DateSetting(int month, DayOfWeek dayOfWeek) {
        this.month = month;
        this.dayOfWeek = dayOfWeek;
    }

    public int getMonth() {
        return month;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
