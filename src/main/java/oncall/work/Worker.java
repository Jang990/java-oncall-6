package oncall.work;

import oncall.calendar.Date;

public class Worker {
    public final Date date;
    public final String name;
    private final String WEEKDAY_FORMAT = "%d월 %d일 %s %s";
    private final String HOLIDAY_FORMAT = "%d월 %d일 %s(휴일) %s";

    public Worker(Date date, String name) {
        this.date = date;
        this.name = name;
    }

    @Override
    public String toString() {
        if(date.isHoliday())
            return formatted(HOLIDAY_FORMAT);
        return formatted(WEEKDAY_FORMAT);
    }

    private String formatted(String format) {
        return format.formatted(
                date.getMonth(),
                date.getDay(),
                date.getDayOfWeek().getName(),
                name
        );
    }
}
