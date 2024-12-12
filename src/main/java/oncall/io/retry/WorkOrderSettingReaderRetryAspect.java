
package oncall.io.retry;

import oncall.io.ErrorMessageFormatter;
import oncall.io.date.DateSetting;
import oncall.io.date.DateSettingReader;
import oncall.io.work.WorkOrderSetting;
import oncall.io.work.WorkOrderSettingReader;

public class WorkOrderSettingReaderRetryAspect extends WorkOrderSettingReader {
    private final WorkOrderSettingReader reader;

    public WorkOrderSettingReaderRetryAspect(WorkOrderSettingReader workOrderSettingReader) {
        super(null);
        this.reader = workOrderSettingReader;
    }

    @Override
    public WorkOrderSetting read() {
        try {
            return reader.read();
        } catch (IllegalArgumentException e) {
            System.out.println(
                    ErrorMessageFormatter.formatted(e.getMessage()));
            return read();
        }
    }
}
