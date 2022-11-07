package Views;

import Controllers.LoginController;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import java.util.Arrays;


public class LoginView extends View{
    public LoginView() {
        super("Sign in");

        Panel panel = Panels.horizontal();
        Panel panel2 = Panels.vertical();
        Panel leftPanel = Panels.vertical();
        Panel rightPanel = Panels.vertical();
        panel.addComponent(leftPanel).addComponent(rightPanel);

        panel2.addComponent(new Label("   _____           _                      _                                             \n" +
                "  / ____|         | |                    | |                      /\\                    \n" +
                " | |        __ _  | |   ___   _ __     __| |   __ _   _ __       /  \\     _ __    _ __  \n" +
                " | |       / _` | | |  / _ \\ | '_ \\   / _` |  / _` | | '__|     / /\\ \\   | '_ \\  | '_ \\ \n" +
                " | |____  | (_| | | | |  __/ | | | | | (_| | | (_| | | |       / ____ \\  | |_) | | |_) |\n" +
                "  \\_____|  \\__,_| |_|  \\___| |_| |_|  \\__,_|  \\__,_| |_|      /_/    \\_\\ | .__/  | .__/ \n" +
                "                                                                         | |     | |    \n" +
                "                                                                         |_|     |_|    "));
        panel2.addComponent(panel);
        TextBox login = new TextBox("", TextBox.Style.SINGLE_LINE);
        TextBox password = new TextBox("", TextBox.Style.SINGLE_LINE);

        leftPanel.addComponent(new EmptySpace(new TerminalSize(0,1)));
        rightPanel.addComponent(new EmptySpace(new TerminalSize(0,1)));
        leftPanel.addComponent(new Label("Login"));
        rightPanel.addComponent(login);


        leftPanel.addComponent(new EmptySpace(new TerminalSize(0,1)));
        rightPanel.addComponent(new EmptySpace(new TerminalSize(0,1)));

        leftPanel.addComponent(new Label("Password"));
        rightPanel.addComponent(password.setMask('*'));

        leftPanel.addComponent(new EmptySpace(new TerminalSize(0,1)));
        rightPanel.addComponent(new EmptySpace(new TerminalSize(0,1)));
        leftPanel.addComponent(new Button("Exit", () -> ((LoginController)Controller).Exit()));
        rightPanel.addComponent(new Button("Log in", () -> ((LoginController)Controller).Login(login.getText(), password.getText())));

        setHints(Arrays.asList(Hint.CENTERED));
        setComponent(panel2);
        setFocusedInteractable(login);
    }
}
