package Views;

import Controllers.EditTaskController;
import Models.Category;
import Models.Task;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.Window;

import java.time.LocalDate;
import java.util.Arrays;

public class DetailsView extends View{
    public DetailsView(Task task){
        super("Details");
        Panel panel = new Panel();
        panel.addComponent(new Label("Date:"));
        panel.addComponent(new Label(task.getDate().toString()));

        panel.addComponent(new Label("Name: "));
        panel.addComponent(new Label(task.getName()));

        panel.addComponent(new Label("Duration: "));
        panel.addComponent(new Label(task.getDuration()));

        panel.addComponent(new Label("Important: "));
        panel.addComponent(new Label(task.getImportant() ? "Yes" : "No"));

        panel.addComponent(new Label("Description: "));
        panel.addComponent(new Label(task.getDescription()));

        panel.addComponent(new Label("Category: "));
        panel.addComponent(new Label(task.getCategory()));

        panel.addComponent(new Button("Cancel",()->{
            Controller.CancelAction();
        }));

        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);
    }
}
