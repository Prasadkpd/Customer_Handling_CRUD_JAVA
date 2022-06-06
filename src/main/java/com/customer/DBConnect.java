package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    //create database connection
    private static String dbUrl = "jdbc:mysql://localhost:3306/Java_Login";
    private static String dbUser = "root";
    private static String dbPassword = "";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (Exception e) {
            System.out.println("Database Connection is Not Success");
        }
        return connection;
    }
}
