package Views;

import Controllers.DeleteTaskController;
import Models.Task;

import javax.swing.*;
import java.awt.*;

public class DeleteTaskView extends View{

    private JPanel panel = new JPanel();

    private JButton confirmButton = new JButton("Confirm");

    private JButton cancelButton = new JButton("Cancel");

    private JLabel confirmLabel = new JLabel("Are you sure u want to delete this task?");
    public DeleteTaskView(JTable table, Task task){
        super("Delete Task");
        createComponents(table, task);
        Container container = getContentPane();
        container.add(panel);
        setup();
        setSize(300,100);
    }
    public void createComponents(JTable table, Task task){
        panel.setLayout(new BorderLayout());
        confirmButton.addActionListener(e -> {
            ((DeleteTaskController)Controller).DeleteTask(table, task);
            Controller.CancelAction();
        });
        cancelButton.addActionListener(e->{
            Controller.CancelAction();
        });
        panel.add(confirmLabel,BorderLayout.PAGE_START);
        panel.add(confirmButton,BorderLayout.LINE_START);
        panel.add(cancelButton,BorderLayout.LINE_END);
    }
}
