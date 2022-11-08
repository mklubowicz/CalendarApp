package Views;

import Controllers.DeleteTaskController;
import Models.Task;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;

import java.util.Arrays;

public class DeleteTaskView extends View{

    public DeleteTaskView(Table<Object> table, Task task){
        super("Delete Task");
        Panel panel = new Panel();
        panel.addComponent(new EmptySpace(new TerminalSize(0,1)));
        panel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
        panel.addComponent(new Label("Are you sure you want to delete task?"));
        panel.addComponent(new EmptySpace(new TerminalSize(0,1)));
        Panel panel2 = new Panel();
        panel.addComponent(panel2);
        panel2.setLayoutManager(new LinearLayout(Direction.HORIZONTAL));
        panel2.addComponent(new EmptySpace(new TerminalSize(0,1)));


        panel2.addComponent(new Button("Cancel",()->{
            Controller.CancelAction();
        }));
        panel2.addComponent(new EmptySpace(new TerminalSize(7,1)));
        panel2.addComponent(new Button("Delete",()->{

            ((DeleteTaskController)Controller).DeleteTask(table, task);
            Controller.CancelAction();
        }));

        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);
    }
}
