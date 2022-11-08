package Controllers;

import Main.UIManager;
import Models.Task;
import Views.*;
import com.googlecode.lanterna.gui2.table.Table;
import com.googlecode.lanterna.gui2.table.TableModel;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;


public class CalendarController extends Controller{

    public void AddTask(Table<Object> table){
        View AddTaskView = new AddTaskView(table);
        UIManager.addWindow(AddTaskView);
    }
    public void EditTask(Table<Object> table, Task task){
        View EditTaskView = new EditTaskView(table,task);
        UIManager.addWindow(EditTaskView);
    }
    public void DeleteTask(Table<Object> table, Task task){
        View DeleteTaskView = new DeleteTaskView(table, task);
        UIManager.addWindow(DeleteTaskView);
    }
    public void SearchCalendar(Table<Object> table, LocalDate date){
        TableModel<Object> searchedTasks = new TableModel<>("Name", "Duration", "Category", "Important");
        Task.search(date).stream()
                .map(Task::toTableRow)
                .forEachOrdered(searchedTasks::addRow);
        table.setTableModel(searchedTasks);
    }

    public void DetailsTask(Task selectedTask) {
        View DetailsView = new DetailsView(selectedTask);
        UIManager.addWindow(DetailsView);
    }
}
