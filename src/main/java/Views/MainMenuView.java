package Views;

import Controllers.MainMenuController;
import Models.User;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;


public class MainMenuView extends View {

    private JPanel panel = new JPanel();

    private JLabel welcomeUserLabel = new JLabel("Welcome "+User.getLoggedUser().getUsername());

    private JLabel dateLabel;

    private LocalDate date;

    private JButton mainCalendarButton = new JButton("Full calendar");

    private JButton aboutMeButton = new JButton("About me");

    private JButton logoutButton = new JButton("Log out");
    private JTable table = new JTable();

    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    public MainMenuView() {
        super("Menu");
        createComponents();
        Container container = getContentPane();
        container.add(panel);
        setup();

    }

    public void createComponents(){
        LocalDate date = java.time.LocalDate.now();

        panel.add(leftPanel);
        panel.add(rightPanel);
        panel.setLayout(new GridLayout(0,2));
        leftPanel.setLayout(new BorderLayout());
        rightPanel.setLayout(new GridLayout(0,1));
        rightPanel.add(welcomeUserLabel);
        welcomeUserLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeUserLabel.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
        dateLabel = new JLabel("Today's schedule! \n Date: "+ date);
        leftPanel.add(dateLabel, BorderLayout.PAGE_START);

        table = ((MainMenuController)Controller).SearchCalendar(date);
        leftPanel.add(new JScrollPane(table));
        mainCalendarButton.addActionListener(e -> {
            ((MainMenuController)Controller).ToCalendar();
        });
        aboutMeButton.addActionListener(e -> {
            ((MainMenuController)Controller).ToAbout();
        });
        logoutButton.addActionListener(e ->{
            ((MainMenuController)Controller).Logout();
        });
        rightPanel.add(mainCalendarButton);
        rightPanel.add(aboutMeButton);
        rightPanel.add(logoutButton);

    }
}
