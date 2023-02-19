package service;

import model.Customer;

import java.util.*;

public class CustomerService {

    private static CustomerService INSTANCE;
    private static final List<Customer> customers = new LinkedList<>();


    private CustomerService() {}

    public static CustomerService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new CustomerService();
        }
        return INSTANCE;
    }

    public void addCustomer(String firstName, String lastName, String email) {
        try {
            Customer customer = new Customer(firstName, lastName, email);
            customers.add(customer);
            System.out.println("Account Created");
        } catch (IllegalArgumentException e) {
            System.out.println("Could not add customer.  Please check that email is valid");
        }
    }

    public Customer getCustomer(String customerEmail) {
        //loop through our list and return a customer when the email matches
        for (Customer customer : customers) {
            if(customer.getEmail().equals(customerEmail)) {
                return customer;
            }
        }
        return null;
    }

    public Collection<Customer> getAllCustomers() {
            return customers;
        }
}
