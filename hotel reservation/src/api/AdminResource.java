package api;

import model.Customer;
import model.IRoom;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;


import java.util.Collection;
import java.util.List;

public class AdminResource {
    private static AdminResource INSTANCE;
    private static CustomerService customerInstance = CustomerService.getInstance();
    private static ReservationService reservationInstance = ReservationService.getInstance();



    private AdminResource() {}

    public static AdminResource getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new AdminResource();
        }
        return INSTANCE;
    }

    public Customer getCustomer(String email) {
        return customerInstance.getCustomer(email);
    }


    public void createARoom(String roomNumber, Double price, RoomType roomType) {
        reservationInstance.createARoom(roomNumber, price, roomType);
    }

    public void addRoom(List<IRoom> rooms) {
        for (IRoom room : rooms) {
            reservationInstance.addRoom(room);
        }
    }

    public Collection<IRoom> getAllRooms() {
        return reservationInstance.getAllRooms();
    }

    public Collection<Customer> getAllCustomers() {
        return customerInstance.getAllCustomers();
    }

    public void displayAllReservations() {
        reservationInstance.printAllReservation();
    }
}
