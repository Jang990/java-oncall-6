package oncall.work;

import oncall.calendar.Date;
import oncall.io.date.DayOfWeek;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    @Test
    void 상태를_출력할_수_있다() {
        assertEquals("5월 6일 토 AA",
                new Worker(new Date(5, 6, DayOfWeek.토, false), "AA").toString());
    }

    @Test
    void 평일이지만_공휴일일_때_휴일을_출력한다() {
        assertEquals("5월 5일 금(휴일) 준식",
                new Worker(new Date(5, 5, DayOfWeek.금, true), "준식").toString());
    }

}