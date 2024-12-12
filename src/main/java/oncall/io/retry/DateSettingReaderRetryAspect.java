package oncall.io.retry;

import oncall.io.ErrorMessageFormatter;
import oncall.io.InputReader;
import oncall.io.date.DateSetting;
import oncall.io.date.DateSettingReader;

public class DateSettingReaderRetryAspect extends DateSettingReader{
    private final DateSettingReader reader;

    public DateSettingReaderRetryAspect(DateSettingReader dateSettingReader) {
        super(null);
        this.reader = dateSettingReader;
    }

    @Override
    public DateSetting read() {
        try {
            return reader.read();
        } catch (IllegalArgumentException e) {
            System.out.println(
                    ErrorMessageFormatter.formatted(e.getMessage()));
            return read();
        }
    }
}
