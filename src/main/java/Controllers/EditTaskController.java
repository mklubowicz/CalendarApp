package Controllers;

import Models.Task;
import com.googlecode.lanterna.gui2.table.Table;

import java.time.LocalDate;

public class EditTaskController extends Controller{

    public void EditTask(Table<Object> table, Task task,Task newTask, String date){
        int globalid = Task.findTaskId(Task.getAll(),task);
        int localid = Task.findTaskId(Task.listOfTasksForDate(LocalDate.parse(date)),task);
        Task.edit(globalid,newTask);
        table.getTableModel().setCell(0,localid,newTask.getName());
        table.getTableModel().setCell(1,localid,newTask.getDuration());
        table.getTableModel().setCell(2,localid,newTask.getCategory());
        table.getTableModel().setCell(3,localid,newTask.getImportant() ? "    ❗" : "" );
    }
}
