package Views;

import Controllers.AddTaskController;
import Controllers.CalendarController;
import Models.Category;
import Models.Task;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;

import java.time.LocalDate;
import java.util.Arrays;

public class AddTaskView extends View{

    public AddTaskView(Table<Object> table){
        super("Add task");
        Panel panel = new Panel();

        TextBox nameTextBox = new TextBox();
        TextBox durationTextBox = new TextBox();
        TextBox dateTextBox = new TextBox();
        TextBox descriptionTextBox = new TextBox();
        TextBox categoryTextBox = new TextBox();
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

        panel.addComponent(new Button("Add",()->{

            ((AddTaskController)Controller).AddTask(table,new Task(LocalDate.parse(dateTextBox.getText()),nameTextBox.getText(),importantCheckBox.isEnabled(),durationTextBox.getText(),descriptionTextBox.getText(),new Category(categoryTextBox.getText())));
            Controller.CancelAction();
        }));

        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);

    }
}
