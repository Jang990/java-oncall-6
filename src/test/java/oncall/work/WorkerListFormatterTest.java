package oncall.work;

import oncall.calendar.Date;
import oncall.io.date.DayOfWeek;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkerListFormatterTest {

    @Test
    void 근무자_리스트를_포매팅한다() {
        WorkerListFormatter formatter = new WorkerListFormatter();

        String result = formatter.formatted(List.of(
                new Worker(new Date(5, 1, DayOfWeek.월, false), "준팍"),
                new Worker(new Date(5, 2, DayOfWeek.화, false), "도밥"),
                new Worker(new Date(5, 3, DayOfWeek.수, false), "고니"),
                new Worker(new Date(5, 4, DayOfWeek.목, false), "수아"),
                new Worker(new Date(5, 5, DayOfWeek.금, true), "루루"),
                new Worker(new Date(5, 6, DayOfWeek.토, false), "수아")
        ));

        assertEquals("""
                5월 1일 월 준팍
                5월 2일 화 도밥
                5월 3일 수 고니
                5월 4일 목 수아
                5월 5일 금(휴일) 루루
                5월 6일 토 수아
                """, result);
    }

}