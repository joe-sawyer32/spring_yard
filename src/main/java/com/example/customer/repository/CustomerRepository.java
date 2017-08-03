package com.example.customer.repository;

import com.example.customer.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository {
    void add(Customer customer);

    void update(Customer customer);

    Customer getById(int id);

    List<Customer> getAll();

    void delete(int id);
}
