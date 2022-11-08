package Controllers;

import Models.Task;
import com.googlecode.lanterna.gui2.table.Table;

public class AddTaskController extends Controller{

    public void AddTask(Table<Object> table, Task task){
        Task.add(task);
        table.getTableModel().addRow(task.toTableRow());
    }
}
