package com.example.customer.repositories;

import com.example.customer.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String ADD_SQL = "INSERT INTO customers (firstName, lastName, phone, email) VALUES (?,?,?,?)";
    @Override
    public void add(Customer customer) {
        jdbcTemplate.update(ADD_SQL, customer.getFirstName(), customer.getLastName(), customer.getPhone(),
                customer.getEmail());
    }

    private String UPDATE_SQL = "UPDATE customers SET firstName = ?, lastName = ?, phone = ?, email = ?) WHERE id = ?";
    @Override
    public void update(Customer customer) {
        jdbcTemplate.update(UPDATE_SQL, customer.getFirstName(), customer.getLastName(), customer.getPhone(),
                customer.getEmail(), customer.getId());
    }

    private String GET_BY_ID_SQL = "SELECT * FROM customers WHERE id = ?";
    @Override
    public Customer getById(int id) {
        return jdbcTemplate.queryForObject(GET_BY_ID_SQL, new CustomerMapper(), id);
    }

    private String GET_ALL_SQL = "SELECT * FROM customers";
    @Override
    public List<Customer> getAll() {
        return jdbcTemplate.query(GET_ALL_SQL, new CustomerMapper());
    }

    private String DELETE_SQL = "DELETE FROM customers WHERE id = ?";
    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_SQL, id);
    }

    private class CustomerMapper implements RowMapper<Customer>{
        @Override
        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            Customer customer = new Customer();
            customer.setId(resultSet.getInt("id"));
            customer.setFirstName(resultSet.getString("firstName"));
            customer.setLastName(resultSet.getString("lastName"));
            customer.setPhone(resultSet.getString("phone"));
            customer.setEmail(resultSet.getString("email"));
            return customer;
        }
    }
}