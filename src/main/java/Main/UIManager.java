package Main;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class UIManager {
    private static UIManager instance;
    private final MultiWindowTextGUI Gui;
    private final AtomicBoolean quitMark;


    static void setup() throws IOException {
        instance = new UIManager();
    }

    private UIManager() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();


        quitMark = new AtomicBoolean(false);
        EmptySpace background = new EmptySpace(new TextColor.RGB(9,101,184));
        Gui = new MultiWindowTextGUI(new SeparateTextGUIThread.Factory(),
                screen, new DefaultWindowManager(),
                new WindowShadowRenderer(),
                background);
        ((AsynchronousTextGUIThread)Gui.getGUIThread()).start();
    }

    public static void addWindow(Window window) {
        synchronized(UIManager.class) {
            instance.Gui.addWindow(window);
        }
    }

    public static void popWindow() {
        synchronized(UIManager.class) {
            instance.Gui.getActiveWindow().close();
        }
    }

    public static void hideTop() {
        synchronized(UIManager.class) {
            instance.Gui.getActiveWindow().setVisible(false);
        }
    }

    public static void showTop() {
        synchronized(UIManager.class) {
            instance.Gui.getActiveWindow().setVisible(true);
        }
    }

    public static void showMessageDialog(String title, String text, MessageDialogButton button) {
        synchronized(UIManager.class) {
            MessageDialog.showMessageDialog(instance.Gui, title, text, button);
        }
    }

    public static void closeGui() {
        synchronized(UIManager.class) {
            try {
                instance.quitMark.set(true);
                instance.Gui.getScreen().close();
                ((TerminalScreen)instance.Gui.getScreen()).getTerminal().close();
            }
            catch(IOException e) {
            }
        }
    }
}
