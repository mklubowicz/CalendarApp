package Controllers;
import Main.UIManager;
import Models.Task;
import Views.*;

import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.gui2.table.Table;
import com.googlecode.lanterna.gui2.table.TableModel;

import java.time.LocalDate;

public class MainMenuController extends Controller{

    public void Logout() {
        View LoginView = new LoginView();

        UIManager.popWindow();
        UIManager.addWindow(LoginView);
        UIManager.showMessageDialog("", "Logged out", MessageDialogButton.OK);
    }

    public void ToCalendar(){
        View CalendarView = new CalendarView();
        UIManager.hideTop();
        UIManager.addWindow(CalendarView);
    }
    public void ToAbout(){
        View AboutView = new AboutView();
        UIManager.hideTop();
        UIManager.addWindow(AboutView);
    }
    public void SearchCalendar(Table<Object> table, LocalDate date){
        TableModel<Object> searchedTasks = new TableModel<>("Name", "Duration", "Category", "Important");
        Task.search(date).stream()
                .map(Task::toTableRow)
                .forEachOrdered(searchedTasks::addRow);
        table.setTableModel(searchedTasks);
    }

}
