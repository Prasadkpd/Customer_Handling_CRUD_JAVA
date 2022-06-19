package com.customer;

import javax.swing.text.EditorKit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerDBUtil {

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static boolean isSuccess;

    public static List<Customer> validate(String userName, String password) {

        ArrayList<Customer> customer = new ArrayList<>();
        //validate
        try {
            connection = DBConnect.getConnection();
            statement = connection.createStatement();
            String query = "SELECT * FROM customer WHERE username='" + userName + "' AND password='" + password + "'";

            resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                customerData(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //assign value to customer array object
        return customer;
    }

    public static boolean createUser(String name, String email, String phone, String userName, String password) {
        isSuccess = false;

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

    public static boolean updateUser(String id, String name, String email, String phone, String userName, String password) {
        try {
            connection = DBConnect.getConnection();
            statement = connection.createStatement();
            String query = "UPDATE customer SET name='" + name + "', email='" + email + "',phone='" + phone + "',username='" + userName + "',password='" + password + "' WHERE id='" + id + "' ";

            int result = statement.executeUpdate(query);

            if (result > 0) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }

        } catch (Exception e) {

        }

        return isSuccess;
    }

    public static List<Customer> getCustomerDetails(String Id) {

        ArrayList<Customer> customer = new ArrayList<>();
        int convertedId = Integer.parseInt(Id);

        try {
            connection = DBConnect.getConnection();
            statement = connection.createStatement();
            String query = "SELECT * from customer where id ='" + convertedId + "' ";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                customerData(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customer;
    }

    private static void customerData(ArrayList<Customer> customer) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String email = resultSet.getString(3);
        String phone = resultSet.getString(4);
        String userName = resultSet.getString(5);
        String password = resultSet.getString(6);

        Customer customerObject = new Customer(id, name, email, phone, userName, password);
        customer.add(customerObject);
    }

    public static boolean deleteUser(String id) {

        int convertedId = Integer.parseInt(id);

        try{
            connection = DBConnect.getConnection();
            statement = connection.createStatement();
            String query = "DELETE from customer where id ='" + convertedId + "' ";
            int result = statement.executeUpdate(query);

            if (result > 0) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

}
