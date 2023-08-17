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
public class ProfileEdit extends JFrame{
	private JPanel p;
	private JLabel mainl, fname, lname, mobile, id, ssn, address, email, password, acnum;
	private JTextField fnametf, lnametf, mobiletf, idtf, ssntf, addresstf, emailtf, passwordtf, acnumtf;
	private JButton change;
	int x;
	/**
	 * 
	 */
	public ProfileEdit(Statement statement, int accnum) {

		super("Banking Application");
		
mainl = new JLabel("Edit your Profile Information", SwingConstants.CENTER);
		
		p = new JPanel(new GridLayout(9,2));
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
		
		acnum = new JLabel("Account: ");
		acnumtf = new JTextField();
		
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
		p.add(acnum);
		p.add(acnumtf);
		
		change = new JButton("Change Account Info");
		change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ResultSet result = null;
                // Insert the user data into the AccountInfo table
                String sql = "UPDATE AccountInfo SET " +
                	    "fname = '" + fnametf.getText().toString() + "', " +
                	    "lname = '" + lnametf.getText().toString() + "', " +
                	    "mobile = '" + mobiletf.getText().toString() + "', " +
                	    "id = '" + idtf.getText().toString() + "', " +
                	    "ssn = '" + ssntf.getText().toString() + "', " +
                	    "address = '" + addresstf.getText().toString() + "', " +
                	    "email = '" + emailtf.getText().toString() + "', " +
                	    "password = '" + passwordtf.getText().toString() + "' " +
                	    "WHERE accnum = '" + acnumtf.getText() + "';";
                try {
					statement.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	JOptionPane.showMessageDialog(null, "Profile Edit made successful");
            	dispose();
            	new MainFrame(statement, accnum).setVisible(true);
            }});
		
		add(mainl, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		add(change, BorderLayout.SOUTH);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
