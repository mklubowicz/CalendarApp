package Controllers;


import Main.UIManager;

public class Controller {

    public void GoBack(){
        UIManager.popWindow();
        UIManager.showTop();
    }
    public void CancelAction(){
        UIManager.popWindow();
    }
}
