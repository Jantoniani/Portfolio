package model;

import service.CustomerService;

public class Tester {

    public static void main(String[] args) {
        Customer customer = new Customer("Jack", "Smith", "jack@email.com");

        System.out.println(customer);
    }
}
