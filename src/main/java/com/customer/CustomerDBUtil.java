package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class CustomerDBUtil {
    public static List<Customer> validate(String userName, String password) {

        ArrayList<Customer> customer = new ArrayList<>();
        //create database connection
        String dbUrl = "jdbc:mysql://localhost:3306/Java_Login";
        String dbUser = "root";
        String dbPassword = "";

        //validate
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM customer WHERE username='" + userName + "' AND password='" + password + "'";

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String phone = resultSet.getString(4);
                String user = resultSet.getString(5);
                String pass = resultSet.getString(6);

                Customer customerData = new Customer(id, name, email, phone, user, pass);
                customer.add(customerData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //assign value to customer array object
        return customer;
    }

    public static boolean createUser(String name, String email, String phone, String userName, String password) {
        boolean isSuccess = false;

        //create database connection
        String dbUrl = "jdbc:mysql://localhost:3306/Java_Login";
        String dbUser = "root";
        String dbPassword = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement statement = connection.createStatement();

            String query = "INSERT INTO customer VALUES (0,'" + name + "','" + email + "','" + phone + "','" + userName + "','" + password + "')";

            int result = statement.executeUpdate(query);

            if (result > 0) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccess;
    }
}
