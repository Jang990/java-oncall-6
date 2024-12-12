package oncall.io.date;

public enum DayOfWeek {
    월("월", 0),
    화("화", 1),
    수("수", 2),
    목("목", 3),
    금("금", 4),
    토("토", 5),
    일("일", 6);

    private static final String ERROR_MESSAGE = "유효하지 않은 입력 값입니다. 다시 입력해 주세요.";

    private final String name;
    private final int id;

    DayOfWeek(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static DayOfWeek of(String dayOfWeek) {
        for (DayOfWeek value : DayOfWeek.values()) {
            if(value.getName().equals(dayOfWeek))
                return value;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
