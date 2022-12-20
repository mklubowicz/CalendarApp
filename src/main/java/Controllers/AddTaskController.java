package Controllers;

import Main.UIManager;
import Models.Task;
import Views.CalendarView;
import Views.MainMenuView;
import Views.View;
import com.googlecode.lanterna.gui2.table.Table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;

public class AddTaskController extends Controller{

    public void AddTask(JTable table, Task task){
        Task.add(task);
        if(task.getDate().equals(LocalDate.now())){
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.addRow(task.toTableRow());
        }
    }


}
