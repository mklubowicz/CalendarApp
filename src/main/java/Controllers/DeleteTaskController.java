package Controllers;

import Models.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DeleteTaskController extends Controller{
    public void DeleteTask(JTable table, Task task){
        int id = Task.findTaskId(Task.listOfTasksForDate(task.getDate()),task);
        Task.delete(task);
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.removeRow(id);
    }
}
