package oncall.calendar;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LegalHoliday {
    private static Map<Integer, List<Integer>> monthAndHoliday = Map.of(
             1, List.of(1),
            3, List.of(1),
            5, List.of(5),
            6, List.of(6),
            8, List.of(15),
            10,List.of(3, 9),
            12, List.of(25)
    );

    public static List<Integer> getHoliday(int month) {
        return monthAndHoliday.getOrDefault(month, Collections.emptyList());
    }
}
