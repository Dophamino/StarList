package com.starList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmMain {
    JFrame frmMain;

    frmMain(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int frmWidth=616;
        int frmHeight=488;

        DefaultListModel<String> lmToDo = new DefaultListModel<>();
            lmToDo.addElement("one");
            lmToDo.addElement("two");
        DefaultListModel<String> lmDone = new DefaultListModel<>();
            lmDone.addElement("three");
            lmDone.addElement("four");

        frmMain = new JFrame("The list of the bright stars");
        frmMain.setBounds((int) ((screenSize.getWidth()-frmWidth)/2),
                (int) ((screenSize.getHeight()-frmHeight)/2),
                frmWidth,frmHeight);
        frmMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frmMain.setResizable(false);
        frmMain.setLayout(null);

        JList<String> toDoList = new JList<>(lmToDo);
        JList<String> doneList = new JList<>(lmDone);

        toDoList.setBounds(16,16,232,416);
            toDoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            toDoList.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    doneList.clearSelection();
                }
            });
            frmMain.add(toDoList);

        doneList.setBounds(352,16,232,416);
            doneList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            doneList.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    toDoList.clearSelection();
                }
            });
            frmMain.add(doneList);

        JButton doneBtn = new JButton(">>>");
            doneBtn.setBounds(256,16,88,32);
            doneBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (toDoList.getSelectedIndex()>=0){
                        int index = toDoList.getSelectedIndex();
                        String moveVal = toDoList.getSelectedValue();
                        lmDone.addElement(moveVal);
                        lmToDo.remove(index);
                    }
                }
            });
            frmMain.add(doneBtn);
        JButton doBtn = new JButton("<<<");
            doBtn.setBounds(256,56,88,32);
            doBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (doneList.getSelectedIndex()>=0){
                        int index = doneList.getSelectedIndex();
                        String moveVal = doneList.getSelectedValue();
                        lmToDo.addElement(moveVal);
                        lmDone.remove(index);
                    }
                }
            });
            frmMain.add(doBtn);
        JButton upBtn = new JButton("^^^");
            upBtn.setBounds(256,96,88,32);
            upBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((toDoList.getSelectedIndex())>0){
                        String itmValue = toDoList.getSelectedValue();
                        int itmInd = toDoList.getSelectedIndex();
                        lmToDo.remove(itmInd);
                        lmToDo.add(itmInd-1,itmValue);
                        toDoList.setSelectedIndex(itmInd-1);
                    } else if ((doneList.getSelectedIndex())>0){
                        String itmValue = doneList.getSelectedValue();
                        int itmInd = doneList.getSelectedIndex();
                        lmDone.remove(itmInd);
                        lmDone.add(itmInd-1,itmValue);
                        doneList.setSelectedIndex(itmInd-1);
                    }
                }
            });
            frmMain.add(upBtn);
        JButton dnBtn = new JButton("VVV");
            dnBtn.setBounds(256,136,88,32);
            dnBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((toDoList.getSelectedIndex()>=0)&&
                            ((toDoList.getSelectedIndex())<(lmToDo.getSize()-1))){
                        String itmValue = toDoList.getSelectedValue();
                        int itmInd = toDoList.getSelectedIndex();
                        lmToDo.remove(itmInd);
                        lmToDo.add(itmInd+1,itmValue);
                        toDoList.setSelectedIndex(itmInd+1);
                    } else if ((doneList.getSelectedIndex()>=0)&&
                            ((doneList.getSelectedIndex())<(lmDone.getSize()-1))){
                        String itmValue = doneList.getSelectedValue();
                        int itmInd = doneList.getSelectedIndex();
                        lmDone.remove(itmInd);
                        lmDone.add(itmInd+1,itmValue);
                        doneList.setSelectedIndex(itmInd+1);
                    }
                }
            });
            frmMain.add(dnBtn);
        JButton addBtn = new JButton("+++");
            addBtn.setBounds(256,192,88,32);
            addBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String strInput = JOptionPane.showInputDialog("Enter new star's name:");
                    if (lmToDo.contains(strInput)){
                        JOptionPane.showMessageDialog(frmMain,
                                "<html>This star is already on your ToDo list!</html>",
                                "Not added",JOptionPane.WARNING_MESSAGE);
                    } else if (lmDone.contains(strInput)){
                        JOptionPane.showMessageDialog(frmMain,
                                "<html>This star is already on your DONE list!</html>",
                                "Not added",JOptionPane.WARNING_MESSAGE);
                    } else {
                        lmToDo.addElement(strInput);
                    }
                }
            });
            frmMain.add(addBtn);
        JButton renBtn = new JButton("AB -> CD");
            renBtn.setBounds(256,232,88,32);
            renBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (toDoList.getSelectedIndex() >= 0) {
                        String itmValue = toDoList.getSelectedValue();
                        int itmInd = toDoList.getSelectedIndex();
                        String newValue = JOptionPane.showInputDialog("Enter new star's name: ",itmValue);
                        if ((newValue!=null)&&(!newValue.equals(""))) {
                            lmToDo.remove(itmInd);
                            lmToDo.add(itmInd, newValue);
                        }
                    } else if (doneList.getSelectedIndex() >= 0){
                        String itmValue = doneList.getSelectedValue();
                        int itmInd = doneList.getSelectedIndex();
                        String newValue = JOptionPane.showInputDialog("Enter new star's name: ",itmValue);
                        if ((newValue!=null)&&(!newValue.equals(""))){
                            lmDone.remove(itmInd);
                            lmDone.add(itmInd,newValue);
                        }
                    }
                }
            });
            frmMain.add(renBtn);
        JButton delBtn = new JButton("---");
            delBtn.setBounds(256,272,88,32);
            delBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (toDoList.getSelectedIndex() >= 0) {
                        if (lmToDo.getSize()>0){
                            lmToDo.remove(toDoList.getSelectedIndex());
                        }
                    } else if (doneList.getSelectedIndex() >= 0){
                        if (lmDone.getSize()>0){
                            lmDone.remove(doneList.getSelectedIndex());
                        }
                    }
                }
            });
            frmMain.add(delBtn);
    }

    public void frmShow(){
        String pass = "dpa666xxx";
        String input = JOptionPane.showInputDialog("Enter the password:");
        try {
            if (input.equals(pass)) {
                frmMain.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(frmMain, "Password incorrect! See ya, sucker! :)",
                        "Password error", JOptionPane.ERROR_MESSAGE);
                System.exit(666);
            }
        } catch (Exception ex){
            System.exit(666);
        }
    }
}
