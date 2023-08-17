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
public class SuccessfulCreation extends JFrame{
	private JLabel mainl, infol, helpl, cardinfo;
	private JButton ok;
	private int x,y,z,w;
	private JPanel p;
	ResultSet resultcard, resultexpmonth, resultexpyear, resultcvv, resultpin;
	private String card;
	private int month, year, cvv, pin;
	/**
	 * 
	 */
	public SuccessfulCreation(Statement statement, int accnum) {
		super("Banking Application");
		
		mainl = new JLabel("Your account has been created", SwingConstants.CENTER);
		
		infol = new JLabel("Your account number is " + accnum + " and a debit card will be sent to the address you submitted", SwingConstants.CENTER);
		try {
            resultcard = statement.executeQuery("SELECT cardnum FROM CardInfo WHERE accnum = " + accnum + ";");
            if (resultcard.next()) {
                card = resultcard.getString(1);
            }  
            
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		try {
            resultexpmonth = statement.executeQuery("SELECT expmonth FROM CardInfo WHERE accnum = " + accnum + ";");
            if (resultexpmonth.next()) {
                month = resultexpmonth.getInt(1);
            }  
            
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		try {
            resultexpyear = statement.executeQuery("SELECT expyear FROM CardInfo WHERE accnum = " + accnum + ";");
            if (resultexpyear.next()) {
                year = resultexpyear.getInt(1);
            } 
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		try {
			resultcvv = statement.executeQuery("SELECT cvv FROM CardInfo WHERE accnum = " + accnum + ";");
            if (resultcvv.next()) {
                cvv = resultcvv.getInt(1);
            }   
            
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		
		try {
			resultpin = statement.executeQuery("SELECT pin FROM CardInfo WHERE accnum = " + accnum + ";");
            if (resultpin.next()) {
                pin = resultpin.getInt(1);
            } 
            
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		cardinfo = new JLabel("Your card number is "+card+ " with expiration date "+month + "/" + year + " and cvv "+ cvv + " and your pin is " + pin );
		helpl = new JLabel("Click ok to continue", SwingConstants.CENTER);
		
		ok = new JButton("Ok");
		ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new MainFrame(statement, accnum).setVisible(true);
            	dispose();
            }
            });
		
		
		p = new JPanel(new GridLayout(5,1));
		p.add(mainl);
		p.add(infol);
		p.add(cardinfo);
		p.add(ok);
		p.add(helpl);
		
		add(p);
		
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
