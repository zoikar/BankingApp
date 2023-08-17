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
public class ChangePin extends JFrame{
	private JLabel mainl, oldpin, newpin, accnuml;
	private JTextField oldpintf, newpintf, accnumtf;
	private JButton change;
	private JPanel p;
	ResultSet result, res;
	int x;
	/**
	 * 
	 */
	public ChangePin(Statement statement, int accnum) {

		super("Banking Application");
		
		mainl = new JLabel("Change Pin", SwingConstants.CENTER);
		
		p = new JPanel(new GridLayout(3,2));
		oldpin = new JLabel("Old Pin: ");
		oldpintf = new JTextField();
		newpin = new JLabel("New Pin: ");
		newpintf = new JTextField();
		accnuml = new JLabel("Account: ");
		accnumtf = new JTextField();
		
		p.add(oldpin);
		p.add(oldpintf);
		p.add(newpin);
		p.add(newpintf);
		p.add(accnuml);
		p.add(accnumtf);
		
		change = new JButton("Change");
		change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            		result = null;
					result = statement.executeQuery("SELECT pin FROM CardInfo WHERE accnum = " + accnumtf.getText());
					result.next();
					x = result.getInt(1);
					res = null;
					res = statement.executeQuery("UPDATE CardInfo SET pin =" + newpintf.getText() +" WHERE accnum = " + accnumtf.getText()+ ";");
            	} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	
            	JOptionPane.showMessageDialog(null, "Pin Change made successful");
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
