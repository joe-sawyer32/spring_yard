package com.example.customer.repositories;

import com.example.customer.domains.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    void add(Customer customer);

    void update(Customer customer);

    Customer getById(int id);

    List<Customer> getAll();

    void delete(int id);
}
