package oncall.work;

import oncall.io.work.WorkOrderSetting;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkerListTest {

    @Test
    void 근무자를_순서대로_순환하며_확인할_수_있다() {
        WorkerList workerList = new WorkerList(new WorkOrderSetting(
                List.of("1", "2", "3"),
                List.of("11", "22", "33")
        ));

        assertEquals("1", workerList.findWeekDayWorker());
        assertEquals("2", workerList.findWeekDayWorker());
        assertEquals("3", workerList.findWeekDayWorker());
        assertEquals("1", workerList.findWeekDayWorker());

        assertEquals("11", workerList.findHolidayWorker());
        assertEquals("22", workerList.findHolidayWorker());
        assertEquals("33", workerList.findHolidayWorker());
        assertEquals("11", workerList.findHolidayWorker());
    }

    @Test
    void 휴일근무자가_2연속_근무한다면_다음_근무자와_바꿈() {
        WorkerList workerList = new WorkerList(new WorkOrderSetting(
                List.of("1", "2", "3"),
                List.of("1", "22", "33")
        ));
        workerList.findWeekDayWorker();

        assertEquals("22", workerList.findHolidayWorker());
        assertEquals("1", workerList.findHolidayWorker());
    }

    @Test
    void 평일근무자가_2연속_근무한다면_다음_근무자와_바꿈() {
        WorkerList workerList = new WorkerList(new WorkOrderSetting(
                List.of("1", "22", "33"),
                List.of("1", "2", "3")
        ));
        workerList.findHolidayWorker();

        assertEquals("22", workerList.findWeekDayWorker());
        assertEquals("1", workerList.findWeekDayWorker());
    }

}