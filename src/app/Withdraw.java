package app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class Withdraw extends JFrame {

	private JLabel mainl, amount, accnuml;
	private JTextField amounttf, accnumtf;
	private JButton deposit;
	private JPanel p;
	private static int x, y;
	ResultSet result = null;
	ResultSet res = null;

	public Withdraw(Statement statement, int acnum) {

		super("Banking Application");
		mainl = new JLabel("Give the amount you want to withdraw", SwingConstants.CENTER);

		p = new JPanel(new GridLayout(2, 2));
		amount = new JLabel("Amount: ");
		amounttf = new JTextField();
		accnuml = new JLabel("Account Number: ");
		accnumtf = new JTextField();

		p.add(amount);
		p.add(amounttf);
		p.add(accnuml);
		p.add(accnumtf);

		deposit = new JButton("Withdraw");
		deposit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					res = null;
					res = statement.executeQuery("SELECT balance FROM CardInfo WHERE accnum = " + accnumtf.getText());
					res.next();
					x = res.getInt(1);
					y = Integer.parseInt(amounttf.getText().toString());
					x = x - y;
					result = statement.executeQuery("UPDATE CardInfo SET balance =" + x +" WHERE accnum = " + accnumtf.getText()+ ";");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "Withdraw made successful");
				dispose();
				new MainFrame(statement, acnum).setVisible(true);
			}
		});

		add(mainl, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		add(deposit, BorderLayout.SOUTH);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
