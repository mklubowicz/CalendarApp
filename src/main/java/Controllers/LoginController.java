package Controllers;

import Main.UIManager;
import Models.User;
import Views.MainMenuView;
import Views.LoginView;
import Views.View;


public class LoginController extends Controller{
    public void Show() {
        UIManager.addWindow(new LoginView());
    }
    public void Login(String login, String password) {
        if(User.login(login, password) == null) {
            View LoginView = new LoginView();
            UIManager.popWindow();
            UIManager.addWindow(LoginView);
            UIManager.showMessageDialog("", "User not found");
            return;
        }
        View MainMenu = new MainMenuView();
        UIManager.popWindow();
        UIManager.addWindow(MainMenu);
    }
    public void Exit(){
        UIManager.closeGui();
    }
}
