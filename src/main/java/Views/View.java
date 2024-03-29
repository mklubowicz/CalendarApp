package Views;

import Controllers.Controller;
import com.googlecode.lanterna.gui2.BasicWindow;

import java.lang.reflect.InvocationTargetException;

public class View extends BasicWindow {
    protected Controller Controller;

    public View(String title) {
        super(title);
        controlersMaker();
    }
    public View() {
        super();
        controlersMaker();
    }

    private void controlersMaker() {
        String className = this.getClass().getSimpleName();
        className = className.substring(0, className.length() - 4);
        if (!this.getClass().getPackage().getName().equals("Views")) {
            className = this.getClass().getPackage().getName().substring(6) + "." + className;
        }
        try {
            Controller = (Controllers.Controller) Class.
                    forName("Controllers." + className + "Controller").
                    getDeclaredConstructor().
                    newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
