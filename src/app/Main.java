package app;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Main {
	private static int x=1;
	
    public static void main(String[] args) throws SQLException {
        // Connect to the PostgreSQL database
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BankingApplication", "postgres", "postgres");
        
        // Create a statement object
        Statement statement = connection.createStatement();

        new AccountCreate(statement).setVisible(true);

        // Close the connection to the database
        //connection.close();
    }
}
