package oncall.io.date;

import oncall.io.InputReader;

public class DateSettingReader {
    private static final String DELIMITER = ",";
    private static final String DATE_SETTING_PROMPT = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private static final String ERROR_MESSAGE = "유효하지 않은 입력 값입니다. 다시 입력해 주세요.";

    private final InputReader reader;


    public DateSettingReader(InputReader reader) {
        this.reader = reader;
    }

    public DateSetting read() {
        System.out.println(DATE_SETTING_PROMPT);
        return readDateSetting();
    }

    private DateSetting readDateSetting() {
        String[] args = reader.readLine().split(DELIMITER);
        return new DateSetting(parseMonth(args[0]), DayOfWeek.of(args[1]));
    }

    private int parseMonth(String month) {
        int result = Integer.parseInt(month);
        if(result < 1 || 12 < result)
            throw new IllegalArgumentException(ERROR_MESSAGE);
        return result;
    }
}
