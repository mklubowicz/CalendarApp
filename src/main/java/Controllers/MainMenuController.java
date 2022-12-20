package Controllers;
import Main.UIManager;
import Models.Category;
import Models.Task;
import Views.*;

import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.gui2.table.Table;
import com.googlecode.lanterna.gui2.table.TableModel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

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
