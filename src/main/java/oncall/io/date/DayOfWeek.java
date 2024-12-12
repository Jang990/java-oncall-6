package oncall.io.date;

public enum DayOfWeek {
    월("월", 0, false),
    화("화", 1, false),
    수("수", 2, false),
    목("목", 3, false),
    금("금", 4, false),
    토("토", 5, true),
    일("일", 6, true);

    private static final String ERROR_MESSAGE = "유효하지 않은 입력 값입니다. 다시 입력해 주세요.";

    private final String name;
    private final int id;
    private final boolean isHoliday;

    DayOfWeek(String name, int id, boolean isHoliday) {
        this.name = name;
        this.id = id;
        this.isHoliday = isHoliday;
    }

    public static DayOfWeek of(String dayOfWeek) {
        for (DayOfWeek value : DayOfWeek.values()) {
            if(value.getName().equals(dayOfWeek))
                return value;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public static DayOfWeek getDayOfWeek(int day) {
        for (DayOfWeek value : DayOfWeek.values()) {
            if(value.getId() == day% 7)
                return value;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isHoliday() {
        return isHoliday;
    }
}
