package Views;

import Controllers.AddTaskController;
import Controllers.CalendarController;
import Models.Category;
import Models.Task;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.time.LocalDate;
import java.util.Arrays;

public class AddTaskView extends View{

    private JPanel panel = new JPanel();

    private JTextField nameTextField = new JTextField();

    private JTextField durationTextField = new JTextField();

    private JTextField dateTextField = new JTextField();

    private JTextField descriptionTextField = new JTextField();

    private JTextField categoryTextField = new JTextField();

    private JCheckBox importantCheckBox = new JCheckBox();

    private JButton addButton = new JButton("Add");

    private JButton cancelButton = new JButton("Cancel");

    public AddTaskView(JTable table){
        super("Add task");
        createComponents(table);
        Container container = getContentPane();
        container.add(panel);
        setup();
        setSize(300,350);

    }
    public void createComponents(JTable table){
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        panel.add(new JLabel("Date(YYYY-MM-DD format):"));
        panel.add(dateTextField);
        dateTextField.setMaximumSize(new Dimension(200,20));

        panel.add(new JLabel("Name: "));
        panel.add(nameTextField);
        nameTextField.setMaximumSize(new Dimension(200,20));


        panel.add(new JLabel("Duration: "));
        panel.add(durationTextField);
        durationTextField.setMaximumSize(new Dimension(200,20));


        panel.add(new JLabel("Important: "));
        panel.add(importantCheckBox);

        panel.add(new JLabel("Description: "));
        panel.add(descriptionTextField);
        descriptionTextField.setMaximumSize(new Dimension(400,20));


        panel.add(new JLabel("Category: "));
        panel.add(categoryTextField);
        categoryTextField.setMaximumSize(new Dimension(200,20));


        cancelButton.addActionListener(e -> {
            Controller.CancelAction();
        });

        addButton.addActionListener(e -> {
            ((AddTaskController)Controller).AddTask(table,new Task(
                    LocalDate.parse(dateTextField.getText()),
                    nameTextField.getText(),
                    importantCheckBox.isEnabled(),
                    durationTextField.getText(),
                    descriptionTextField.getText(),
                    categoryTextField.getText()));
            Controller.CancelAction();
        });

        panel.add(cancelButton);
        panel.add(addButton);


    }
}
