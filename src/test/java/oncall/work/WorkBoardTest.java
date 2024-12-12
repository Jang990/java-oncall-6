package oncall.work;

import oncall.calendar.Calendar;
import oncall.io.date.DateSetting;
import oncall.io.date.DayOfWeek;
import oncall.io.work.WorkOrderSetting;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkBoardTest {

    @Test
    void 근무자를_한_명씩_확인할_수_있다() {
        WorkBoard workBoard = new WorkBoard(
                new Calendar(new DateSetting(5, DayOfWeek.월)),
                new WorkerList(
                        new WorkOrderSetting(
                                List.of("준팍","도밥","고니","수아","루루","글로","솔로스타","우코","슬링키","참새","도리"),
                                List.of("수아","루루","글로","솔로스타","우코","슬링키","참새","도리","준팍","도밥","고니")
                        )
                ));

        assertTrue(workBoard.hasMoreWork());
        assertEquals("5월 1일 월 준팍", workBoard.next().toString());
        assertEquals("5월 2일 화 도밥", workBoard.next().toString());
        assertEquals("5월 3일 수 고니", workBoard.next().toString());
        assertEquals("5월 4일 목 수아", workBoard.next().toString());
        assertEquals("5월 5일 금(휴일) 루루", workBoard.next().toString());
        assertEquals("5월 6일 토 수아", workBoard.next().toString());
    }

}