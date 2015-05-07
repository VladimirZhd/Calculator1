package com.company;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by ZhdankiFam on 01.05.2015.
 */
public class ViewCalculatior {
    private JLabel mainLabel;
    private MyButton[] buttons;
    private Model model;

    public ViewCalculatior(Model model) {
        this.model = model;
    }

    public void duildGUI() {
        JFrame frame = new JFrame("Calculatior");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setBounds(200, 200, 450, 450);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                Object[] options = {"Yes", "No"};
                int n = JOptionPane.showOptionDialog(e.getWindow(), "Close the Window?",
                        "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (n == 0) {
                    e.getWindow().setVisible(false);
                    System.exit(0);
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        mainLabel = new JLabel("0");
        // set font
        mainLabel.setFont(new Font(mainLabel.getFont().getName(), Font.BOLD, 40));
        //Setting aligment
        mainLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        // Setting Border
        mainLabel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(4, 1, 4, 4));
        JPanel arithmeticPanel = new JPanel();
        arithmeticPanel.setLayout(new GridLayout(2, 1, 4, 4));
        JPanel numPanel = new JPanel();
        numPanel.setLayout(new GridLayout(4, 3, 4, 4));
        JPanel arithmeticPanel2 = new JPanel();
        arithmeticPanel2.setLayout(new GridLayout(2, 1, 4, 4));
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 5, 4, 4));


        //Number Buttons
        buttons = new MyButton[10];
        NumberButtonListener numberListener = new NumberButtonListener();
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new MyButton(Integer.toString(i));
            buttons[i].addActionListener(numberListener);
        }
        // Dot Button
        MyButton dot = new MyButton(".");


        //Arithmetic buttins
        MyButton add = new MyButton("+");
        MyButton div = new MyButton("/");
        MyButton sub = new MyButton("-");
        MyButton mul = new MyButton("*");


        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                model.action(mainLabel.getText(), '+');
                mainLabel.setText("0");
            }
        });

        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                model.action(mainLabel.getText(), '-');
                mainLabel.setText("0");
            }
        });

        mul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                model.action(mainLabel.getText(), '*');
                mainLabel.setText("0");
            }
        });

        div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                model.action(mainLabel.getText(), '/');
                mainLabel.setText("0");
            }
        });

        //Result Button
        MyButton result = new MyButton("=");

        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double result = model.calculate(mainLabel.getText());
                mainLabel.setText(Double.toString(result));

            }
        });

        //Clean buttons
        MyButton clean = new MyButton("C");
        MyButton backSp = new MyButton("<--");



        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainLabel.setText("0");
            }
        });

        //Memory Buttons
        MyButton memoryClean = new MyButton("MC");
        MyButton memoryR = new MyButton("MR");
        MyButton memoryAdd = new MyButton("M+");
        MyButton memorySub = new MyButton("M-");

        //Negative Button
        MyButton negative = new MyButton("+/-");

        //Percent
        MyButton percent = new MyButton("%");
        percent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                model.action(mainLabel.getText(), '%');
                mainLabel.setText("0");
            }
        });

        //Adding numbers to Panel
        for (int i = 7; i < 10; i++) {
            numPanel.add(buttons[i]);
        }
        for (int i = 4; i < 7; i++) {
            numPanel.add(buttons[i]);
        }
        for (int i = 1; i < 4; i++) {
            numPanel.add(buttons[i]);
        }

        frame.setJMenuBar(new JMenuBar());

        numPanel.add(dot);
        numPanel.add(buttons[0]);
        numPanel.add(result);

        arithmeticPanel2.add(mul);
        arithmeticPanel2.add(sub);
        arithmeticPanel.add(arithmeticPanel2);
        arithmeticPanel.add(add);
        leftPanel.add(percent);
        leftPanel.add(negative);
        leftPanel.add(clean);
        leftPanel.add(backSp);
        northPanel.add(memoryClean);
        northPanel.add(memoryR);
        northPanel.add(memoryAdd);
        northPanel.add(memorySub);
        northPanel.add(div);

        mainPanel.add(BorderLayout.NORTH, northPanel);
        mainPanel.add(BorderLayout.WEST, leftPanel);
        mainPanel.add(BorderLayout.CENTER, numPanel);
        mainPanel.add(BorderLayout.EAST, arithmeticPanel);

        frame.add(BorderLayout.NORTH, mainLabel);
        frame.add(BorderLayout.CENTER, mainPanel);


        frame.setVisible(true);
    }


    private class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            mainLabel.setText(mainLabel.getText() + button.getText());

        }
    }
}
