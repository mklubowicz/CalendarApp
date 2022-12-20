package Views;


import javax.swing.*;
import java.awt.*;

public class AboutView extends View{
    private JPanel panel = new JPanel();
    private JLabel logoLabel = new JLabel(new ImageIcon("src/main/resources/logo.PNG"));

    private JLabel authorLabel = new JLabel("Developed by Michał Kłubowicz");

    private JButton backButton = new JButton("Back");
    public AboutView(){
        super("Author");
        createComponents();
        Container container = getContentPane();
        container.add(panel);
        setup();
    }
    public void createComponents(){
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(logoLabel);
        logoLabel.setMaximumSize(new Dimension(500,500));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> {
            Controller.GoBack();
        });
        panel.add(authorLabel);
        panel.add(backButton);
    }
}
