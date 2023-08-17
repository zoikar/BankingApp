/**
 * 
 */
package app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
/**
 * 
 */
public class MainFrame extends JFrame{
	private JLabel mainl;
	private JButton deposit, withdraw, transfer, balance, pin, profile;
	private JPanel p;
	 ResultSet result = null;
	 int x = 0;
	/**
	 * 
	 */
	public MainFrame(Statement statement, int accnum) {
		super("Banking Application");
		
		mainl = new JLabel("What do you want to do?", SwingConstants.CENTER);
		
		deposit = new JButton("Deposit");
		deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	new Deposit(statement, accnum).setVisible(true);
            }
            });
		withdraw = new JButton("Withdraw");
		withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	new Withdraw(statement, accnum).setVisible(true);
            }
            });
		transfer = new JButton("Transfer Money");
		transfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	new Transfer(statement, accnum).setVisible(true);
            }
            });
		balance = new JButton("View Balance");
		balance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	
            	try {
                    result = statement.executeQuery("SELECT balance FROM CardInfo WHERE accnum = " + accnum + ";");
                    if (result.next()) {
                        System.out.println(result.getInt(1));
                        x = x + result.getInt(1);
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            	new ViewBalance(statement, accnum, x).setVisible(true);
            }
            });
		pin = new JButton("Change Pin");
		pin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	new ChangePin(statement, accnum).setVisible(true);
            }
            });
		profile = new JButton("Profile Edit");
		profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	new ProfileEdit(statement, accnum).setVisible(true);
            }
            });
		
		p = new JPanel(new GridLayout(3,2));
		p.add(deposit);
		p.add(withdraw);
		p.add(transfer);
		p.add(balance);
		p.add(pin);
		p.add(profile);
		
		add(mainl, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
