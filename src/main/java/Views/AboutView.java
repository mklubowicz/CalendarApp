package Views;

import Controllers.AboutController;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.util.Arrays;

public class AboutView extends View{

    public AboutView(){
        super("Author");
        Panel panel = Panels.vertical();
        panel.setLayoutData(BorderLayout.Location.CENTER);
        panel.addComponent(new Label("   _____           _                      _                                             \n" +
                "  / ____|         | |                    | |                      /\\                    \n" +
                " | |        __ _  | |   ___   _ __     __| |   __ _   _ __       /  \\     _ __    _ __  \n" +
                " | |       / _` | | |  / _ \\ | '_ \\   / _` |  / _` | | '__|     / /\\ \\   | '_ \\  | '_ \\ \n" +
                " | |____  | (_| | | | |  __/ | | | | | (_| | | (_| | | |       / ____ \\  | |_) | | |_) |\n" +
                "  \\_____|  \\__,_| |_|  \\___| |_| |_|  \\__,_|  \\__,_| |_|      /_/    \\_\\ | .__/  | .__/ \n" +
                "                                                                         | |     | |    \n" +
                "                                                                         |_|     |_|    "));
        panel.addComponent(new EmptySpace(new TerminalSize(0,1)));
        Panel panel2 = Panels.horizontal();
        panel.addComponent(panel2);
        panel2.addComponent(new Label("Developed by Michał Kłubowicz"));
        panel2.addComponent(new EmptySpace(new TerminalSize(27,2)));
        panel2.addComponent(new Button("Back",()->{
            Controller.GoBack();
        }));

        setHints(Arrays.asList(Window.Hint.CENTERED));
        setComponent(panel);

    }
}
