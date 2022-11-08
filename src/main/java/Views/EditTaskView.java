package Views;

import Controllers.AddTaskController;
import Controllers.EditTaskController;
import Models.Category;
import Models.Task;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;

import java.time.LocalDate;
import java.util.Arrays;

public class EditTaskView extends View{

    public EditTaskView(Table<Object> table, Task task){
        super("Edit task");
        Panel panel = new Panel();

        TextBox nameTextBox = new TextBox(task.getName(),TextBox.Style.SINGLE_LINE);
        TextBox durationTextBox = new TextBox(task.getDuration(),TextBox.Style.SINGLE_LINE);
        TextBox dateTextBox = new TextBox(task.getDate().toString(),TextBox.Style.SINGLE_LINE);
        TextBox descriptionTextBox = new TextBox(task.getDescription(),TextBox.Style.SINGLE_LINE);
        TextBox categoryTextBox = new TextBox(task.getCategory(),TextBox.Style.SINGLE_LINE);
        CheckBox importantCheckBox = new CheckBox();

        panel.addComponent(new Label("Date(YYYY-MM-DD format):"));
        panel.addComponent(dateTextBox);

        panel.addComponent(new Label("Name: "));
        panel.addComponent(nameTextBox);

        panel.addComponent(new Label("Duration: "));
        panel.addComponent(durationTextBox);

        panel.addComponent(new Label("Important: "));
        panel.addComponent(importantCheckBox);

        panel.addComponent(new Label("Description: "));
        panel.addComponent(descriptionTextBox);

        panel.addComponent(new Label("Category: "));
        panel.addComponent(categoryTextBox);

        panel.addComponent(new Button("Cancel",()->{
            Controller.CancelAction();
        }));

        panel.addComponent(new Button("Edit",()->{

            ((EditTaskController)Controller).EditTask(table,task,new Task(
                    LocalDate.parse(dateTextBox.getText()),
                    nameTextBox.getText(),
                    importantCheckBox.isChecked(),
                    durationTextBox.getText(),
                    descriptionTextBox.getText(),
                    new Category(categoryTextBox.getText())),dateTextBox.getText());
            Controller.CancelAction();
        }));

        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);
    }
}
