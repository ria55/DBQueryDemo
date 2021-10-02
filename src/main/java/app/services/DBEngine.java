package app.services;

import app.models.Address;
import app.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBEngine {

    private final Connection connection;

    public DBEngine() {
        connection = connect();
    }

    public boolean isConnected() {
        return (connection != null);
    }

    private Connection connect() {
        String url = "jdbc:mysql://localhost:3306/user_address_db?useUnicode=yes&characterEncoding=UTF-8";

        try {
            Properties properties = new Properties();
            properties.put("user", System.getenv("DB_USER"));
            properties.put("password", System.getenv("DB_PW"));

            return DriverManager.getConnection(url, properties);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public List<User> findAllUser() {
        String query = "SELECT * FROM user_table";

        List<User> users = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String gender = resultSet.getString("gender");

                User user = new User(id, firstname, lastname, gender);

                List<Address> userAddresses = findAddressForUser(user);

                user.setAddresses(userAddresses);

                users.add(user);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }

    public User findUserById(long userId) {
        String query = "SELECT * FROM user_table WHERE id = " + userId;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String gender = resultSet.getString("gender");

                return new User(id, firstname, lastname, gender);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return new User();
    }

    public List<Address> findAddressForUser(User user) {
        String query = "SELECT * FROM address_table WHERE user_id = " + user.getId();

        List<Address> addresses = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                //long id = resultSet.getLong("id");
                int zip = resultSet.getInt("zip");
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");
                String address = resultSet.getString("address");

                Address addr = new Address(zip, country, city, address);
                addr.setUser(user);

                addresses.add(addr);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return addresses;
    }

}
