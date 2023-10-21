package dev.example.jdbc;
import dev.example.jdbc.customer.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JdbcCustomerRepository {

    private static final Logger logger = LoggerFactory.getLogger(JdbcCustomerRepository.class);
    private final String SELECT_SQL = "select * from customers WHERE name = ?";
    private final String SELECT_ALL_SQL = "select * from customers";
    private final String INSERT_SQL = "INSERT INTO customers(customer_id, name, email) VALUES (UUID_TO_BIN(?), ?, ?)";
    private final String UPDATE_BY_ID_SQL = "UPDATE customers SET name = ? WHERE customer_id = UUID_TO_BIN(?)";
    private final String SELECT_BY_NAME_SQL = "select * from customers WHERE name = ?";
    private final String DELETE_ALL_SQL = "DELETE FROM customers";

    public static void main(String[] args) {
        JdbcCustomerRepository customerRepository = new JdbcCustomerRepository();

//        customerRepository.transactionTest(new Customer(UUID.fromString("e9a6b7c7-6e3d-11ee-985c-0242ac110002"), "update-user", "test00@gmail.com", LocalDateTime.now()));

//        int count = customerRepository.deleteAllCustomer();
//        logger.info("deleted count -> {}", count);
//
        UUID customerId = UUID.randomUUID();
//        logger.info("created customerId -> {}", customerId);
        customerRepository.insertCustomer(customerId, "new-user", "test00@gmail.com");
//        customerRepository.findAllIds().forEach(v -> logger.info("Found customerId : {}", v));
//        customerRepository.updateCustomerName(customerId, "updated-user");
    }

    public List<String> findAllName() {
        List<String> names = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/order_mgmt", "root", "root1234!");
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL);
                ResultSet resultSet = statement.executeQuery();
        ) {
            while(resultSet.next()) {
                String customerName = resultSet.getString("name");
                UUID customerId = UUID.nameUUIDFromBytes(resultSet.getBytes("customer_id"));
                LocalDateTime createAt = resultSet.getTimestamp("create_at").toLocalDateTime();
                names.add(customerName);
            }
        } catch (SQLException e) {
            logger.error("Got error while closing connection", e);
        }

        return names;
    }

    public List<UUID> findAllIds() {
        List<UUID> uuids = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/order_mgmt", "root", "root1234!");
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL);
                ResultSet resultSet = statement.executeQuery();
        ) {
            while(resultSet.next()) {
                String customerName = resultSet.getString("name");
                UUID customerId = toUUID(resultSet.getBytes("customer_id"));
                LocalDateTime createAt = resultSet.getTimestamp("create_at").toLocalDateTime();
                uuids.add(customerId);
            }
        } catch (SQLException e) {
            logger.error("Got error while closing connection", e);
        }

        return uuids;
    }

    public int insertCustomer(UUID customerId, String name, String email) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/order_mgmt", "root", "root1234!");
                PreparedStatement statement = connection.prepareStatement(INSERT_SQL);
        ) {
            statement.setBytes(1, customerId.toString().getBytes());
            statement.setString(2, name);
            statement.setString(3, email);
            return statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Got error while closing connection", e);
        }
        return 0;
    }

    public int updateCustomerName(UUID customerId, String name) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/order_mgmt", "root", "root1234!");
                PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID_SQL);
        ) {
            statement.setBytes(2, customerId.toString().getBytes());
            statement.setString(1, name);
            return statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Got error while closing connection", e);
        }
        return 0;
    }

    public int deleteAllCustomer() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/order_mgmt", "root", "root1234!");
                PreparedStatement statement = connection.prepareStatement(DELETE_ALL_SQL);
        ) {
            return statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Got error while closing connection", e);
        }
        return 0;
    }

    public void transactionTest(Customer customer) {
        String updateNameSql = "UPDATE customers SET name = ? WHERE customer_id = UUID_TO_BIN(?)";
        String updateEmailSql = "UPDATE customers SET name = ? WHERE customer_id = UUID_TO_BIN(?)";

//        Connection con = null;
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/order_mgmt", "root", "root1234!");
                PreparedStatement updateNameStatement = connection.prepareStatement(updateNameSql);
                PreparedStatement updateEmailStatement = connection.prepareStatement(updateEmailSql);
        ) {
            updateNameStatement.setString(1, customer.getEmail());
            updateNameStatement.setBytes(2, customer.getCustomerId().toString().getBytes());

            updateNameStatement.setString(1, customer.getName());
            updateNameStatement.setBytes(2, customer.getCustomerId().toString().getBytes());
        } catch (SQLException e) {
            logger.error("Got error while closing connection", e);
        }
    }

    private List<String> findByNames(String name) {
        List<String> names = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/order_mgmt", "root", "root1234!");
                PreparedStatement statement = connection.prepareStatement(SELECT_SQL);
        ) {
            statement.setString(1, name);
            logger.info("statement -> {}", statement);
            try (ResultSet resultSet = statement.executeQuery()) {
                while(resultSet.next()) {
                    String customerName = resultSet.getString("name");
                    UUID customerId = UUID.nameUUIDFromBytes(resultSet.getBytes("customer_id"));
                    LocalDateTime createAt = resultSet.getTimestamp("create_at").toLocalDateTime();
                    logger.info("customer id -> {}, name -> {}, createAt -> {}", customerId, customerName, createAt);
                    names.add(customerName);
                }
            }
        } catch (SQLException e) {
            logger.error("Got error while closing connection", e);
        }

        return names;
    }

    static UUID toUUID(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        return new UUID(byteBuffer.getLong(), byteBuffer.getLong());
    }
}
