package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDBUtil {

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    public static List<Customer> validate(String userName, String password) {

        ArrayList<Customer> customer = new ArrayList<>();
        //validate
        try {
            connection = DBConnect.getConnection();
            statement = connection.createStatement();
            String query = "SELECT * FROM customer WHERE username='" + userName + "' AND password='" + password + "'";

            resultSet = statement.executeQuery(query);

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

        try {
            connection = DBConnect.getConnection();
            statement = connection.createStatement();
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
