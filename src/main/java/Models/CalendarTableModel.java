package Models;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CalendarTableModel extends DefaultTableModel {
    public CalendarTableModel(){
        super(new Object[]{"Name", "Duration", "Category", "Important","",""},0);
    }
    @Override
    public Class<?> getColumnClass(int column) {
        switch(column){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Boolean.class;
            default:
                return JButton.class;
        }
    }
}
