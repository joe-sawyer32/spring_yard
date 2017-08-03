package com.example.customer.common;

import com.example.customer.models.Customer;

import java.util.List;

public class CustomerServiceTestUtils {

    public static Customer createTestCustomer() {
        // Get unique data every time this test runs
        String fn = Long.toString(System.currentTimeMillis());
        String ln = Long.toString(System.currentTimeMillis());
        String p = Long.toString(System.currentTimeMillis());
        String e = Long.toString(System.currentTimeMillis()) + "@domain.com";

        Customer c = new Customer();
        c.setFirstName(fn);
        c.setLastName(ln);
        c.setPhone(p);
        c.setEmail(e);
        return c;
    }


    public static Customer findInList(List<Customer> customers, String first, String last, String phone, String email) {
        // Find the new customer in the list
        for (Customer c : customers) {
            if (c.getFirstName().equals(first) &&
                    c.getLastName().equals(last) &&
                    c.getPhone().equals(phone) &&
                    c.getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }
}
