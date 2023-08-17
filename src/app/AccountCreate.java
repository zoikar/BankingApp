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
public class AccountCreate extends JFrame {

	private JPanel p;
	private JLabel mainl, fname, lname, mobile, id, ssn, address, email, password;
	private JTextField fnametf, lnametf, mobiletf, idtf, ssntf, addresstf, emailtf, passwordtf;
	private JButton create;
	private static int x;
	/**
	 * 
	 */
	public AccountCreate(Statement statement) throws SQLException{
		super("Banking Application");
		mainl = new JLabel("Create an Account", SwingConstants.CENTER);
		
		p = new JPanel(new GridLayout(8,2));
		fname = new JLabel("First Name: ");
		fnametf = new JTextField();
		
		lname = new JLabel("Last Name: ");
		lnametf = new JTextField();
		
		mobile = new JLabel("Mobile Number: ");
		mobiletf = new JTextField();
		
		id = new JLabel("ID Number: ");
		idtf = new JTextField();
		
		ssn = new JLabel("Social Security Number: ");
		ssntf = new JTextField();
		
		address = new JLabel("Address: ");
		addresstf = new JTextField();
		
		email = new JLabel("Email: ");
		emailtf = new JTextField();
		
		password = new JLabel("Password: ");
		passwordtf = new JTextField();
		
		p.add(fname);
		p.add(fnametf);
		p.add(lname);
		p.add(lnametf);
		p.add(mobile);
		p.add(mobiletf);
		p.add(id);
		p.add(idtf);
		p.add(ssn);
		p.add(ssntf);
		p.add(address);
		p.add(addresstf);
		p.add(email);
		p.add(emailtf);
		p.add(password);
		p.add(passwordtf);
		
		create = new JButton("Create Account");
		create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ResultSet result = null;
				try {
					result = statement.executeQuery("SELECT accnum FROM AccountInfo ORDER BY accnum DESC LIMIT 1;");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                try {
					if (result.next()) {
					    x = result.getInt("accnum");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                x = x+1;
                // Insert the user data into the AccountInfo table
                String sql = "INSERT INTO AccountInfo(accnum, fname, lname, mobile, id, ssn, address, email, password) VALUES ('" + x + "','" + fnametf.getText().toString() + "', '" + lnametf.getText().toString() + "', '" + mobiletf.getText().toString() + "', '" + idtf.getText().toString() + "', '" + ssntf.getText().toString() + "', '" + addresstf.getText().toString() + "', '" + emailtf.getText().toString() + "', '" + passwordtf.getText().toString() + "');";
                try {
					statement.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                try {
					new CardCreate(statement, x);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                new SuccessfulCreation(statement, x).setVisible(true);
                dispose();
            }});
		
		add(mainl, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		add(create, BorderLayout.SOUTH);
		
		
		

		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}


}
