package Views;

import Controllers.CalendarController;
import Controllers.MainMenuController;
import Main.Main;
import Models.User;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;

import java.time.LocalDate;
import java.util.Arrays;


public class MainMenuView extends View {

    public MainMenuView() {
        super("Menu");
        LocalDate date = java.time.LocalDate.now();
        Panel panel = Panels.horizontal();
        Panel leftPanel = Panels.vertical();
        Panel rightPanel = Panels.vertical();
        panel.addComponent(leftPanel).addComponent(rightPanel);

        panel.setLayoutManager(new GridLayout(2));
        rightPanel.addComponent(new Label("Welcome: "));
        rightPanel.addComponent(new Label(User.getLoggedUser().getUsername()));
        rightPanel.addComponent(new EmptySpace(new TerminalSize(0,1)));
        rightPanel.addComponent(new EmptySpace(new TerminalSize(0,1)));

        leftPanel.addComponent(new Label("Todays schedule!\n Date: "+ date));

        Table<Object> table = new Table<Object>("");
        ((MainMenuController)Controller).SearchCalendar(table, date);

        leftPanel.addComponent(table
                .setPreferredSize(new TerminalSize(70, 20))
                .withBorder(Borders.singleLine())
        );

        rightPanel.addComponent(new ActionListBox()
                .addItem("Full calendar", ()->{
                    ((MainMenuController)Controller).ToCalendar();
                })
                .addItem("About us", ()->{
                    ((MainMenuController)Controller).ToAbout();
                })
        );


        panel.addComponent(new EmptySpace(new TerminalSize(0,2)));
        panel.addComponent(new EmptySpace(new TerminalSize(0,2)));

        panel.addComponent(new Button("Log out", () ->{
            ((MainMenuController)Controller).Logout();
        }));


        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);
    }
}
