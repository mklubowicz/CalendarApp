package Controllers;

import Models.Task;
import com.googlecode.lanterna.gui2.table.Table;

public class EditTaskController extends Controller{

    public void EditTask(Table<Object> table, Task task,Task newTask){
        int id = Task.findTaskId(task);
        Task.getAll().set(id,newTask);
        table.getTableModel().setCell(0,id,newTask.getName());
        table.getTableModel().setCell(1,id,newTask.getDuration());
        table.getTableModel().setCell(2,id,newTask.getCategory());
        table.getTableModel().setCell(3,id,newTask.getImportant() ? "    ❗" : "" );
    }
}
