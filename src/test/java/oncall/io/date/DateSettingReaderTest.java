package oncall.io.date;

import oncall.io.InputReaderStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateSettingReaderTest {

    @Test
    void 월과_시작요일을_입력받음() {
        InputReaderStub inputReaderStub = new InputReaderStub("5,월");
        DateSettingReader reader = new DateSettingReader(inputReaderStub);

        DateSetting result = reader.read();

        assertEquals(result.getMonth(), 5);
        assertEquals(result.getDayOfWeek(), DayOfWeek.월);
    }

    @Test
    void 잘못된_입력이_들어오면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class,
                () -> new DateSettingReader(new InputReaderStub("-1,월")).read());
        assertThrows(IllegalArgumentException.class,
                () -> new DateSettingReader(new InputReaderStub("5,밈")).read());
    }

}