package Views;

import Models.Category;
import Models.Task;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Arrays;

public class DetailsView extends View{
    private JPanel panel = new JPanel();

    public DetailsView(Task task){
        super("Details");
        createComponents(task);
        Container container = getContentPane();
        container.add(panel);
        setup();
        setSize(250,250);
    }

    public void createComponents(Task task) {
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        panel.add(new JLabel("Date:"));
        panel.add(new JLabel(task.getDate().toString()));

        panel.add(new JLabel("Name: "));
        panel.add(new JLabel(task.getName()));

        panel.add(new JLabel("Duration: "));
        panel.add(new JLabel(task.getDuration()));

        panel.add(new JLabel("Important: "));
        panel.add(new JLabel(task.getImportant() ? "Yes" : "No"));

        panel.add(new JLabel("Description: "));
        panel.add(new JLabel(task.getDescription()));

        panel.add(new JLabel("Category: "));
        panel.add(new JLabel(task.getCategory()));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
