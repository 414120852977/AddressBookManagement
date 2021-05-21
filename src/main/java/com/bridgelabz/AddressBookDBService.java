package com.bridgelabz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {
    List<Contact> list = new ArrayList<>();
    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/address_book_service?useSSL=false";
        String userName = "root";
        String password = "root";
        Connection connection;
        System.out.println("Connecting to database:" + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is successful!!!!!!" + connection);
        return connection;
    }

    public List<Contact> readData() {
        String sql = "select * from address_book";
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            String firstName = resultSet.getNString("firstName");
            String lastName = resultSet.getNString("lastName");
                String address = resultSet.getNString("address");
                String state = resultSet.getNString("state");
                String city = resultSet.getNString("city");
                String email = resultSet.getNString("email");
                int zip = resultSet.getInt("zip");
               int phoneNo = resultSet.getInt("phoneNumber");
                list.add(new Contact(firstName,lastName,address,state,city,email,zip,phoneNo));
            }

    }catch (SQLException e) {
        e.printStackTrace();
        }
        return list;
    }

    public void showDatabaseRetrivedData() {
        System.out.println("persons data->"+list);
    }
}

