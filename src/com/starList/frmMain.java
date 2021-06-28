package com.starList;

import javax.swing.*;
import java.awt.*;

public class frmMain {
    JFrame frmMain;

    frmMain(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int frmWidth=616;
        int frmHeight=488;

        String[] strToDo = {"empty", "emptyAgain"};
        String[] strDone = {"empty", "emptyAgain"};

        JList<String> toDoList = new JList<>(strToDo);
        JList<String> doneList = new JList<>(strDone);

        frmMain = new JFrame("Список ярких звезд");
        frmMain.setBounds((int) ((screenSize.getWidth()-frmWidth)/2),
                (int) ((screenSize.getHeight()-frmHeight)/2),
                frmWidth,frmHeight);
        frmMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frmMain.setResizable(false);
        frmMain.setLayout(null);

        toDoList.setBounds(16,16,208,416);
            frmMain.add(toDoList);
        doneList.setBounds(376,16,208,416);
        frmMain.add(doneList);
    }

    public void frmShow(){
        /*String pass = "dpaxxx";
        String input = JOptionPane.showInputDialog("Введите пароль:");
        if (input.equals(pass)){
            frmMain.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(frmMain,"Пароль введен неверно! До свидания! :)",
                    "Ошибка пароля",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }*/
        frmMain.setVisible(true);
    }
}
