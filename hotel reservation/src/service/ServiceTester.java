package service;

import model.Customer;
import model.Room;
import model.RoomType;
import service.CustomerService;

import java.util.Date;

public class ServiceTester {

    public static void main(String[] args) {

        CustomerService instance = CustomerService.getInstance();
        instance.addCustomer("Jack", "Smith", "js@email.com");
        instance.addCustomer("Sam", "Salamander", "ss@email.com");
        instance.addCustomer("John", "Wick", "jw@email.com");

        System.out.println(instance.getCustomer("jw@email.com"));

        System.out.println(instance.getAllCustomers());

        ReservationService resInstance = ReservationService.getInstance();

        Room suite = new Room("215", 400.0, RoomType.SINGLE);
        Room junior = new Room("217", 250.0, RoomType.DOUBLE);
        Room suite2 = new Room("220", 400.0, RoomType.SINGLE);


        resInstance.addRoom(suite);
        resInstance.addRoom(junior);
        resInstance.addRoom(suite2);

        System.out.println(resInstance.getARoom("215"));
        System.out.println(resInstance.getARoom("217"));

        Customer mike = new Customer("Mike", "Sanchez", "mike@email.com");


        Date checkIn = new Date(2023,10,22);
        Date checkOut = new Date(2023, 10,25);

        System.out.println(resInstance.reserveARoom(mike, suite, checkIn, checkOut));

        Date checkIn2 = new Date(2023, 8, 12);
        Date checkOut2 = new Date(2023, 8, 14);

        System.out.println(resInstance.findRooms(checkIn2, checkOut2));



    }
}
