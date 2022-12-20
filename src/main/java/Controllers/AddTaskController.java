package Controllers;

import Models.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;

public class AddTaskController extends Controller{

    public void AddTask(JTable table, Task task){
        Task.add(task);
        if(task.getDate().equals(LocalDate.now())){
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.addRow(task.toSuperTableRow());
        }
    }


}
