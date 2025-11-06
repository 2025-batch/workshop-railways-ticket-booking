package com.khadri.mvc.ticketbooking.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection connection;

    public static void createConnection(String driver, String url, String username, String password) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
