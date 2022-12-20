package Controllers;

import Main.UIManager;
import Models.CalendarTableModel;
import Models.Task;
import Views.*;
import com.googlecode.lanterna.gui2.table.Table;
import com.googlecode.lanterna.gui2.table.TableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;


public class CalendarController extends Controller{
    private CalendarTableModel model = new CalendarTableModel();

    public void AddTask(JTable table){
        View AddTaskView = new AddTaskView(table);
        UIManager.addWindow(AddTaskView);
    }
    public void DeleteTask(JTable table, Task task){
        View DeleteTaskView = new DeleteTaskView(table, task);
        UIManager.addWindow(DeleteTaskView);
    }
    public void SearchCalendar(JTable table, LocalDate date){
        model.setRowCount(0);
        Task.search(date).stream()
                .map(Task::toTableRow)
                .forEachOrdered(model::addRow);

        table.setModel(model);

        for(int i = 0;i< table.getRowCount();i++){
            model.setValueAt("Delete",i,4);
            model.setValueAt("Details",i,5);
        }
    }
    @Override
    public void GoBack(){
        View MainMenuView = new MainMenuView();
        UIManager.popWindow();
        UIManager.addWindow(MainMenuView);
    }

    public void DetailsTask(Task selectedTask) {
        View DetailsView = new DetailsView(selectedTask);
        UIManager.addWindow(DetailsView);
    }
}
