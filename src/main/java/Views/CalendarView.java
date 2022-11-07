package Views;

import Controllers.CalendarController;
import Controllers.MainMenuController;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;

import java.time.LocalDate;
import java.util.Arrays;

public class CalendarView extends View{

    public LocalDate date = java.time.LocalDate.now();
    public CalendarView(){
        super("Calendar");
        Panel panel = Panels.horizontal();
        Panel topPanel = Panels.horizontal();
        Panel tablePanel = new Panel();
        Panel rightPanel = Panels.vertical();

        ActionListBox actionList = new ActionListBox();
        actionList
                .addItem("Add", () -> {

                })
                .addItem("Edit", () -> {

                })
                .addItem("Delete", () -> {

                })
                .setPreferredSize(new TerminalSize(10,25))
                .setEnabled(false);

        rightPanel.addComponent(topPanel).addComponent(tablePanel);
        panel.addComponent(actionList).addComponent(rightPanel);

        topPanel.setLayoutManager(new BorderLayout());



        tablePanel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
        Table<Object> table = new Table<Object>("");

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


        setHints(Arrays.asList(Hint.CENTERED));
        setComponent(panel);
    }
}
