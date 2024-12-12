package oncall.io.work;

import oncall.io.InputReader;

import java.util.*;

public class WorkOrderSettingReader {
    private static final String WEEKDAY_PROMPT = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요>";
    private static final String HOLIDAY_PROMPT = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>";
    private static final String ERROR_MESSAGE = "유효하지 않은 입력 값입니다. 다시 입력해 주세요.";
    private static final String DELIMITER = ",";
    private static final int MIN = 5;
    private static final int MAX = 35;
    private static final int MAX_NICKNAME_LENGTH = 5;

    private final InputReader reader;

    public WorkOrderSettingReader(InputReader reader) {
        this.reader = reader;
    }

    public WorkOrderSetting read() {
        System.out.println(WEEKDAY_PROMPT);
        List<String> weekday = readList();

        System.out.println(HOLIDAY_PROMPT);
        List<String> holiday = readList();

        validate(weekday, holiday);
        return new WorkOrderSetting(weekday, holiday);
    }

    private void validate(List<String> weekday, List<String> holiday) {
        if(hasDuplicatedName(weekday)
                || hasDuplicatedName(weekday)
                || hasOnce(weekday, holiday)
                || weekday.size() < MIN || weekday.size() > MAX
                || hasOutOfNicknameLength(weekday))
            throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    private boolean hasOutOfNicknameLength(List<String> names) {
        return names.stream()
                .mapToInt(String::length)
                .anyMatch(len -> len > MAX_NICKNAME_LENGTH);
    }

    private boolean hasDuplicatedName(List<String> names) {
        return new HashSet<>(names).size() != names.size();
    }

    private boolean hasOnce(List<String> weekday, List<String> holiday) {
        Map<String, Integer> map = new HashMap<>();
        weekday.forEach(name -> map.put(name, map.getOrDefault(name, 0) + 1));
        holiday.forEach(name -> map.put(name, map.getOrDefault(name, 0) + 1));
        return map.keySet().stream()
                .map(map::get)
                .anyMatch(cnt -> cnt == 1);
    }

    private List<String> readList() {
        return Arrays.stream(reader.readLine().split(DELIMITER))
                .toList();
    }
}
