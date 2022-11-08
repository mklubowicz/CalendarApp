package Views;

import Controllers.CalendarController;
import Controllers.MainMenuController;
import Models.Task;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;

import javax.naming.ldap.Control;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static Models.Task.getAll;

public class CalendarView extends View{

    public LocalDate date = java.time.LocalDate.now();

    public String name ="";
    public Task selectedTask = null;
    public CalendarView(){
        super("Calendar");
        Panel panel = Panels.horizontal();
        Panel topPanel = Panels.horizontal();
        Panel tablePanel = new Panel();
        Panel rightPanel = Panels.vertical();

        Table<Object> table = new Table<Object>("");

        ActionListBox actionList = new ActionListBox();
        ActionListBox actionList2 = new ActionListBox();

        actionList
                .addItem("Add", () -> {
                    ((CalendarController)Controller).AddTask(table);

                })
                .setPreferredSize(new TerminalSize(10,25))
                .setEnabled(true);

        actionList2
                .addItem("Edit", () -> {
                    ((CalendarController)Controller).EditTask(table,selectedTask);
                    actionList.setEnabled(true);
                    actionList2.setEnabled(false);
                })
                .addItem("Delete", () -> {
                    ((CalendarController)Controller).DeleteTask(table,selectedTask);
                    actionList.setEnabled(true);
                    actionList2.setEnabled(false);
                })
                .addItem("Details", () -> {
                    ((CalendarController)Controller).DetailsTask(selectedTask);
                    actionList.setEnabled(true);
                    actionList2.setEnabled(false);
                })
                .setPreferredSize(new TerminalSize(10,25))
                .setEnabled(false);
        table.setSelectAction(()->{
            List<Task> taskList = Task.search(date);
            selectedTask = taskList.stream()
                    .filter(task->taskList.indexOf(task) ==  table.getSelectedRow())
                    .findFirst()
                    .get();
            name = selectedTask.getName();
            actionList.setEnabled(false);
            actionList2.setEnabled(true);
            setFocusedInteractable(actionList2);
        });

        rightPanel.addComponent(topPanel).addComponent(tablePanel);
        panel.addComponent(actionList).addComponent(actionList2).addComponent(rightPanel);

        topPanel.setLayoutManager(new BorderLayout());



        tablePanel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
        Label currentDate = new Label(date.toString());

        Button prevDateButton = new Button("<-",()-> {
            date = date.minusDays(1);
            currentDate.setText(date.toString());
            ((CalendarController) Controller).SearchCalendar(table, date);
        });
        prevDateButton.setPreferredSize(new TerminalSize(35,1));

        Button nextDateButton = new Button("->",()-> {
            date = date.plusDays(1);
            currentDate.setText(date.toString());
            ((CalendarController) Controller).SearchCalendar(table, date);
        });
        nextDateButton.setPreferredSize(new TerminalSize(35,1));


        prevDateButton.setLayoutData(BorderLayout.Location.LEFT);
        currentDate.setLayoutData(BorderLayout.Location.CENTER);
        nextDateButton.setLayoutData(BorderLayout.Location.RIGHT);

        topPanel.addComponent(prevDateButton);
        topPanel.addComponent(currentDate);
        topPanel.addComponent(nextDateButton);


        ((CalendarController)Controller).SearchCalendar(table, date);
        tablePanel.addComponent(table
                .setPreferredSize(new TerminalSize(70, 20))
                .withBorder(Borders.singleLine())
        );

        panel.addComponent(new Button("Back",()->{
            Controller.GoBack();
        }));
        setHints(Arrays.asList(Hint.CENTERED));
        setComponent(panel);
    }
}
