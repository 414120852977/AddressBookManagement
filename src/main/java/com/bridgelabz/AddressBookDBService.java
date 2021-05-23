package com.bridgelabz;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    List<Contact> getAddressBookDatas(String firstName) {
        List<Contact> list = null;
        if(this.addressBookDataStatement == null)
            this.prepareStatementForAddressBookData();
        try{
            addressBookDataStatement.setString(1,firstName);
            ResultSet resultSet = addressBookDataStatement.executeQuery();
            list = this.getAddressBookData(resultSet);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public List<Contact> getAddressBookData(ResultSet resultSet) {
        List<Contact> list  = new ArrayList<>();
        try {
            while (resultSet.next()){
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                String state = resultSet.getString("state");
                String city = resultSet.getString("city");
                String email = resultSet.getString("email");
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

    public Map<String, Integer> getContactsByCityOrState() {
        AddressBookDBService addressBookDBService = new AddressBookDBService();
        Map<String, Integer> contactByCityOrStateMap = new HashMap<>();
        ResultSet resultSet;
        String sqlCity = "SELECT city, count(firstName) as count from address_book group by city; ";
        String sqlState = "SELECT state, count(firstName) as count from address_book group by state; ";
        try (Connection connection = addressBookDBService.getConnection()) {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlCity);
            while (resultSet.next()) {
                String city = resultSet.getString("city");
                Integer count = resultSet.getInt("count");
                contactByCityOrStateMap.put(city,count);
            }
            resultSet = statement.executeQuery(sqlState);
            while (resultSet.next()) {
                String state = resultSet.getString("state");
                Integer count = resultSet.getInt("count");
                contactByCityOrStateMap.put(state,count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactByCityOrStateMap;
    }

    public Contact addContact(String firstName, String lastName, String address, String city, LocalDate start, String state, int zip, int phoneNumber, String email, String name, String type) {

        Connection connection = null;
        try {
            connection = this.getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            assert connection != null;
            Statement statement = connection.createStatement();
            String sql = String.format(
                    "INSERT INTO address_book" +
                            "(firstName,lastName,address,city,start,state,zip,phoneNumber,email,Name,TYPE) " +
                            "values ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                     firstName, lastName, address, city,start, state, zip, phoneNumber, email,name,type);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e.printStackTrace();
            }
        }
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new Contact( firstName, lastName, address, state, city, email, zip, phoneNumber, LocalDate.now());
    }
}

