package com.bridgelabz;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {
    List<Contact> list = new ArrayList<>();
    private PreparedStatement addressBookDataStatement;

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
               LocalDate start = resultSet.getDate("start").toLocalDate();
                list.add(new Contact(firstName,lastName,address,state,city,email,zip,phoneNo,start));
            }

    }catch (SQLException e) {
        e.printStackTrace();
        }
        return list;
    }

    public void showDatabaseRetrivedData() {
        System.out.println("persons data->"+list);
    }

    public void updateInformationToContact(String firstName) {
        String sql = " update address_book SET city = 'uganda' where firstName = 'joe';";
        try (Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
             statement.executeUpdate(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contact> getContactForGivenDateRange(LocalDate startDate, LocalDate endDate) {
        String sql = String.format(
                "SELECT * from address_book WHERE start BETWEEN '%s' AND '%s';",
                Date.valueOf(startDate), Date.valueOf(endDate));
        return this.getContactDetailsUsingSqlQuery(sql);

    }
    private List<Contact> getContactDetailsUsingSqlQuery(String sql) {
        List<Contact> list = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            list = this.getAddressBookData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

//    private List<Contact> getAddressBookData(String name) {
//        List<Contact> list = null;
//        if(this.addressBookDataStatement == null)
//            this.prepareStatementForAddressBookData();
//        try{
//            addressBookDataStatement.setString(1,name);
//            ResultSet resultSet = addressBookDataStatement.executeQuery();
//            list = this.getAddressBookData(String.valueOf(resultSet));
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
//        return list;
//    }
    public List<Contact> getAddressBookData(ResultSet resultSet) {
        List<Contact> list  = new ArrayList<>();
        try {
            while (resultSet.next()){
                String firstName = resultSet.getNString("firstName");
                String lastName = resultSet.getNString("lastName");
                String address = resultSet.getNString("address");
                String state = resultSet.getNString("state");
                String city = resultSet.getNString("city");
                String email = resultSet.getNString("email");
                int zip = resultSet.getInt("zip");
                int phoneNo = resultSet.getInt("phoneNumber");
                LocalDate start = resultSet.getDate("start").toLocalDate();
                list.add(new Contact(firstName,lastName,address,state,city,email,zip,phoneNo,start));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list ;
    }

    private void prepareStatementForAddressBookData() {
        try {
            Connection connection = this.getConnection();
            String sql = "SELECT * FROM address_book WHERE name = ?";
            addressBookDataStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

