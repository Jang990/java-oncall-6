package oncall.io.work;

import java.util.List;

public class WorkOrderSetting {
    private final List<String> weekday;
    private final List<String> holiday;

    public WorkOrderSetting(List<String> weekday, List<String> holiday) {
        this.weekday = weekday;
        this.holiday = holiday;
    }

    public List<String> getWeekday() {
        return weekday;
    }

    public List<String> getHoliday() {
        return holiday;
    }
}
