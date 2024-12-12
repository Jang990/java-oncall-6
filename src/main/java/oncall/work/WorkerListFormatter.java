package oncall.work;

import java.util.List;

public class WorkerListFormatter {
    public String formatted(List<Worker> workers) {
        StringBuilder sb = new StringBuilder();
        workers.forEach(worker -> sb.append(worker).append("\n"));
        return sb.toString();
    }
}
