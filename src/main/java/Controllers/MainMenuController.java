package Controllers;

import Main.UIManager;
import Models.Task;
import Views.AboutView;
import Views.CalendarView;
import Views.LoginView;
import Views.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;

public class MainMenuController extends Controller{

    public void Logout() {
        View LoginView = new LoginView();

        UIManager.popWindow();
        UIManager.addWindow(LoginView);
        UIManager.showMessageDialog("", "Logged out");
    }

    public void ToCalendar(){
        View CalendarView = new CalendarView();
        UIManager.popWindow();
        UIManager.addWindow(CalendarView);
    }
    public void ToAbout(){
        View AboutView = new AboutView();
        UIManager.popWindow();
        UIManager.addWindow(AboutView);
    }
    public JTable SearchCalendar(LocalDate date){
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Name", "Duration", "Category", "Important"},0);
        Task.search(date).stream()
                .map(Task::toTableRow)
                .forEachOrdered(model::addRow);
        JTable table = new JTable(model) {
            @Override
            public Class<?> getColumnClass(int column) {
                switch(column){
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        return table;
    }

}
