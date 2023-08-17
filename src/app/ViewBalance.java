package app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class ViewBalance extends JFrame {

    private JLabel mainl, balance;
    private JButton ok;
   

    public ViewBalance(Statement statement, int accnum, int x) {
        super("Banking Application");

        mainl = new JLabel("Balance", SwingConstants.CENTER);
        balance = new JLabel("Your balance is " + x, SwingConstants.CENTER);
        ok = new JButton("Ok");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainFrame(statement, accnum).setVisible(true);
            }
        });

        add(mainl, BorderLayout.NORTH);
        add(balance, BorderLayout.CENTER);
        add(ok, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
