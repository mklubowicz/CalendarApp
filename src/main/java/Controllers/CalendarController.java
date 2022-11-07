package Controllers;

import Main.UIManager;
import Models.Task;
import Views.AddTaskView;
import Views.DeleteTaskView;
import Views.EditTaskView;
import Views.View;
import com.googlecode.lanterna.gui2.table.Table;
import com.googlecode.lanterna.gui2.table.TableModel;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;


public class CalendarController extends Controller{

    public void AddTask(Table<Object> table){
        View AddClientView = new AddTaskView(table);
        UIManager.addWindow(AddClientView);
    }
    public void EditTask(Table<Object> table, String name){
        View ModifyClientView = new EditTaskView(table,name);
        UIManager.addWindow(ModifyClientView);
    }
    public void DeleteTask(Table<Object> table, String name){
        View DeleteClientView = new DeleteTaskView(table, name);
        UIManager.addWindow(DeleteClientView);
    }
    public void SearchCalendar(Table<Object> table, LocalDate date){
        TableModel<Object> searchedTasks = new TableModel<>("Name", "Duration", "Category", "Important");
        Task.search(date).stream()
                .map(Task::toTableRow)
                .forEachOrdered(searchedTasks::addRow);
        table.setTableModel(searchedTasks);
    }
}
