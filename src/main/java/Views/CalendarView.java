package Views;

import Controllers.CalendarController;
import Controllers.MainMenuController;
import Models.ButtonColumn;
import Models.Task;

import javax.naming.ldap.Control;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static Models.Task.getAll;

public class CalendarView extends View{

    private LocalDate date = java.time.LocalDate.now();
    private String name ="";
    private Task selectedTask = null;

    private JPanel panel = new JPanel();

    private JPanel tablePanel = new JPanel();

    private JPanel datePanel = new JPanel();

    private JButton addButton = new JButton("Add");

    private JButton backButton = new JButton("Back");

    private JButton prevDateButton = new JButton("<-");

    private JButton nextDateButton = new JButton("->");

    private ButtonColumn deleteColumn;

    private ButtonColumn detailsColumn;

    private JTable table = new JTable();

    private JLabel dateLabel = new JLabel(date.toString());

    public void createComponents(){
        GridBagConstraints c = new GridBagConstraints();
        datePanel.setLayout(new FlowLayout());
        panel.setLayout(new BorderLayout());
        addButton.addActionListener(e ->{
            ((CalendarController)Controller).AddTask(table);
        });
        backButton.addActionListener(e ->{
            Controller.GoBack();
        });
        ((CalendarController)Controller).SearchCalendar(table,date);
        Action delete = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
                List<Task> taskList = Task.search(date);
                selectedTask = taskList.stream()
                        .filter(task->taskList.indexOf(task) ==  modelRow)
                        .findFirst()
                        .get();
                ((CalendarController)Controller).DeleteTask(table,selectedTask);
            }
        };

        Action edit = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int modelRow = Integer.valueOf( e.getActionCommand() );
                List<Task> taskList = Task.search(date);
                selectedTask = taskList.stream()
                    .filter(task->taskList.indexOf(task) ==  modelRow)
                    .findFirst()
                    .get();
                ((CalendarController)Controller).DetailsTask(selectedTask);

            }
        };

        deleteColumn = new ButtonColumn(table,delete,4);
        detailsColumn = new ButtonColumn(table, edit,5);

        prevDateButton.addActionListener(e->{
            date = date.minusDays(1);
            dateLabel.setText(date.toString());
            ((CalendarController)Controller).SearchCalendar(table,date);
        });

        nextDateButton.addActionListener(e->{
            date = date.plusDays(1);
            dateLabel.setText(date.toString());
            ((CalendarController)Controller).SearchCalendar(table,date);
        });
        datePanel.add(addButton);
        datePanel.add(prevDateButton);
        datePanel.add(dateLabel);
        datePanel.add(nextDateButton);
        datePanel.add(backButton);
        tablePanel.add(new JScrollPane(table));
        panel.add(datePanel,BorderLayout.PAGE_START);
        panel.add(tablePanel);
    }
    public CalendarView(){
        super("Calendar");
        createComponents();
        Container container = getContentPane();
        container.add(panel);
        setup();
    }

}
