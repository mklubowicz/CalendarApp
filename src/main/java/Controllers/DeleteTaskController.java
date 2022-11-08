package Controllers;

import Models.Task;
import com.googlecode.lanterna.gui2.table.Table;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DeleteTaskController extends Controller{
    public void DeleteTask(Table<Object> table, Task task){
        int id = Task.findTaskId(Task.listOfTasksForDate(task.getDate()),task);
        Task.delete(task);
        table.getTableModel().removeRow(id);
    }
}
