/**
 * 
 */
package app;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.sql.*;
/**
 * 
 */
public class CardCreate{
	/**
	 * It creates the debit card of the user
	 */
	public CardCreate(Statement statement, int x) throws SQLException{
		try {
			} catch (NumberFormatException e) {
			  // Handle the exception here
			}
		
		Random rand = new Random();
		int rnd1 = rand.nextInt(1111, 10000); 
		int rnd2 = rand.nextInt(1111, 10000);
		int rnd3 = rand.nextInt(1111, 10000);
		int rnd4 = rand.nextInt(1111, 10000);
		String cardnum = Integer.toString(rnd1) + Integer.toString(rnd2) + Integer.toString(rnd3) + Integer.toString(rnd4);
		
		
		int expmonth = rand.nextInt(1,13);
		
		int expyear = rand.nextInt(2023, 2031);
		
		int cvv = rand.nextInt(100, 1000);
		
		int pin = rand.nextInt(1000, 10000);
		
		String sql = "INSERT INTO CardInfo(accnum, cardnum, expmonth, expyear, cvv, pin, balance) VALUES (" + x + ", '" + cardnum + "', '" + expmonth + "', '" + expyear + "', '" + cvv + "'," + pin + ", '" + 0 + "');";	try {
			statement.executeUpdate(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
