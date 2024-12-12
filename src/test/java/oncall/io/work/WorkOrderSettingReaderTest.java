package oncall.io.work;

import oncall.io.InputReaderStub;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkOrderSettingReaderTest {

    @Test
    void 비상_근무_순서를_입력받기() {
        InputReaderStub inputReaderStub = new InputReaderStub("준팍,도밥,고니,수아,루루,글로");
        WorkOrderSettingReader reader = new WorkOrderSettingReader(inputReaderStub);

        WorkOrderSetting result = reader.read();
        assertEquals(result.getWeekday(), List.of("준팍", "도밥", "고니", "수아", "루루", "글로"));
        assertEquals(result.getHoliday(), List.of("준팍", "도밥", "고니", "수아", "루루", "글로"));
    }

    @Test
    void 평일_휴일_각각_1회이상_편성되면_예외발생() {
        InputReaderStub inputReaderStub = new InputReaderStub("준팍,도밥,고니,수아,루루,루루");
        assertThrows(IllegalArgumentException.class,
                () -> new WorkOrderSettingReader(inputReaderStub).read());
    }

    @Test
    void _5_35명의_근무자가_아니라면_예외발생() {
        InputReaderStub inputReaderStub1 = new InputReaderStub("1,2,3,4");
        assertThrows(IllegalArgumentException.class,
                () -> new WorkOrderSettingReader(inputReaderStub1).read());

        InputReaderStub inputReaderStub2 = new InputReaderStub(
                "1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6");
        assertThrows(IllegalArgumentException.class,
                () -> new WorkOrderSettingReader(inputReaderStub2).read());
    }

    @Test
    void 닉네임이_5글자보다_크면_예외발생() {
        InputReaderStub inputReaderStub = new InputReaderStub("준팍,도밥,고니,수아,루루,abcdef");
        assertThrows(IllegalArgumentException.class,
                () -> new WorkOrderSettingReader(inputReaderStub).read());
    }

}