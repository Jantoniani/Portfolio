package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    private static HotelResource INSTANCE;
    private static CustomerService customerInstance = CustomerService.getInstance();
    private static ReservationService reservationInstance = ReservationService.getInstance();

    private HotelResource() {}

    public static HotelResource getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new HotelResource();
        }
        return INSTANCE;
    }

    public Customer getCustomer(String email) {
        return customerInstance.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) {
        customerInstance.addCustomer(firstName, lastName, email);
    }

    public IRoom getRoom(String roomNumber) {
        return reservationInstance.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate)  {
        return reservationInstance.reserveARoom(customerInstance.getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        return reservationInstance.getCustomersReservation(customerInstance.getCustomer(customerEmail));
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return reservationInstance.findRooms(checkIn, checkOut);
    }
}
