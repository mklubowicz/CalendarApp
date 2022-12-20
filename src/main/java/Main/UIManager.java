package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.Button;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class UIManager {
    private static UIManager instance;
    private JFrame Gui;


    static void setup() throws IOException {
        instance = new UIManager();
    }

    private UIManager() throws IOException {

        Gui = new JFrame("CalendarApp");
        Gui.setBackground(Color.white);
        Gui.setSize(800,800);
        Gui.setLocationRelativeTo(null);
        Gui.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void addWindow(JFrame frame) {
        synchronized(UIManager.class) {
            instance.Gui = frame;
        }
    }

    public static void popWindow() {
        synchronized(UIManager.class) {
            instance.Gui.dispose();
        }
    }

    public static void hideTop() {
        synchronized(UIManager.class) {
            instance.Gui.setVisible(false);
        }
    }

    public static void showTop() {
        synchronized(UIManager.class) {
            instance.Gui.setVisible(true);
        }
    }

    public static void showMessageDialog(String title, String text) {
        synchronized(UIManager.class) {
            JDialog dialog = new JDialog(instance.Gui,title);
            dialog.add(new JLabel(text));
            dialog.setLayout(new FlowLayout());
            JButton button = new JButton("OK");
            button.addActionListener( e -> {
                dialog.setVisible(false);
                dialog.dispose();
            });
            dialog.add(button);
            dialog.setLocationRelativeTo(null);
            dialog.setSize(100,100);
            dialog.setVisible(true);
        }
    }

    public static void showDialog(JDialog dialog){
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(100,100);
        dialog.setVisible(true);
    }
    public static void closeGui() {
        synchronized(UIManager.class) {
            try {
                instance.Gui.dispose();
            }
            catch(Exception e) {
            }
        }
    }
}
