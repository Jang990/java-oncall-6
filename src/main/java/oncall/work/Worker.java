package oncall.work;

import oncall.calendar.Date;

public class Worker {
    public final Date date;
    public final String name;

    public Worker(Date date, String name) {
        this.date = date;
        this.name = name;
    }
}
