package oncall.calendar;

import oncall.io.date.DateSetting;
import oncall.io.date.DayOfWeek;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarTest {
    @Test
    void 날짜정보를_확인할_수_있다() {
        Calendar calendar = new Calendar(new DateSetting(10, DayOfWeek.월));

        Date result = calendar.getDate(6);

        assertEquals(result.getMonth(), 10);
        assertEquals(result.getDay(), 6);
        assertEquals(result.getDayOfWeek(), DayOfWeek.토);
        assertTrue(result.isHoliday());
        assertFalse(result.isLegalHoliday());
    }

    @Test
    void 법정_공휴일이_적용된다() {
        Calendar calendar = new Calendar(new DateSetting(10, DayOfWeek.월));

        Date result1 = calendar.getDate(3);
        assertEquals(result1.getDayOfWeek(), DayOfWeek.수);
        assertTrue(result1.isLegalHoliday());

        Date result2 = calendar.getDate(9);
        assertEquals(result2.getDayOfWeek(), DayOfWeek.화);
        assertTrue(result2.isLegalHoliday());
    }

    @Test
    void day를_넘겨줄_때_캘린더의_날짜밖이라면_예외발생() {
        Calendar calendar = new Calendar(new DateSetting(10, DayOfWeek.월));
        assertThrows(IllegalArgumentException.class, () -> calendar.getDate(0));
        assertThrows(IllegalArgumentException.class, () -> calendar.isHoliday(0));
        assertThrows(IllegalArgumentException.class, () -> calendar.getDate(32));
        assertThrows(IllegalArgumentException.class, () -> calendar.isHoliday(32));
    }
}