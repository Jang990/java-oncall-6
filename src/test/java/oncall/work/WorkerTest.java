package oncall.work;

import oncall.calendar.Date;
import oncall.io.date.DayOfWeek;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    @Test
    void 상태를_출력할_수_있다() {
        assertEquals("5월 5일 일(휴일) 준식",
                new Worker(new Date(5, 5, DayOfWeek.일, true), "준식").toString());

        assertEquals("5월 6일 월 AA",
                new Worker(new Date(5, 6, DayOfWeek.월, false), "AA").toString());
    }

}