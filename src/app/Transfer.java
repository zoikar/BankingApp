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
public class Transfer extends JFrame{
	private JLabel mainl, amount, youracc, otheracc;
	private JTextField amounttf, youracctf, otheracctf;
	private JButton transfer;
	private JPanel p;
	ResultSet result = null;
	ResultSet res1 = null;
	ResultSet res2 = null;
	int x,y,z,w;
	/**
	 * 
	 */
	public Transfer(Statement statement, int accnum) {

		super("Banking Application");
		
mainl = new JLabel("Give the amount you want to transfer", SwingConstants.CENTER);
		
		p = new JPanel(new GridLayout(3,2));
		amount = new JLabel("Amount: ");
		amounttf = new JTextField();
		youracc = new JLabel("Your Account Number: ");
		youracctf = new JTextField();
		otheracc = new JLabel("The other Account Number: ");
		otheracctf = new JTextField();
		
		p.add(amount);
		p.add(amounttf);
		p.add(youracc);
		p.add(youracctf);
		p.add(otheracc);
		p.add(otheracctf);
		
		transfer = new JButton("Transfer");
		transfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	try {
            		res1 = null;
					res1 = statement.executeQuery("SELECT balance FROM CardInfo WHERE accnum = " + youracctf.getText());
					res1.next();
					x = res1.getInt(1);
					y = Integer.parseInt(amounttf.getText().toString());
					x = x - y;
					result = statement.executeQuery("UPDATE CardInfo SET balance =" + x +" WHERE accnum = " + youracctf.getText()+ ";");
            	} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	try {
					res2 = null;
					res2 = statement.executeQuery("SELECT balance FROM CardInfo WHERE accnum = " + otheracctf.getText());
					res2.next();
					z = res2.getInt(1);
					w = Integer.parseInt(amounttf.getText().toString());
					z = z + w;
					result = statement.executeQuery("UPDATE CardInfo SET balance =" + z +" WHERE accnum = " + otheracctf.getText()+ ";");
            	} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	JOptionPane.showMessageDialog(null, "Transfer made successful");
            	dispose();
            	new MainFrame(statement, accnum).setVisible(true);
            }});
		
		add(mainl, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		add(transfer, BorderLayout.SOUTH);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
