package Controllers;


import Main.UIManager;
import Views.MainMenuView;
import Views.View;

public class Controller {

    public void GoBack(){
        View MainMenuView = new MainMenuView();
        UIManager.popWindow();
        UIManager.addWindow(MainMenuView);
    }
    public void CancelAction(){
        UIManager.popWindow();
    }
}
