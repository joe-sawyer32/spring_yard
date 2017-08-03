package com.example.customer.repositories;

import com.example.customer.models.Customer;

import java.util.List;

public interface CustomerRepository {
    void add(Customer customer);

    void update(Customer customer);

    Customer getById(int id);

    List<Customer> getAll();

    void delete(int id);
}
