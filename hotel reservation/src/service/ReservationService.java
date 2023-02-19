package service;

import model.*;
import java.util.*;

public class ReservationService {
    private static ReservationService INSTANCE;
    private static final Set<IRoom> listOfRooms = new HashSet<>();
    private static final Set<Reservation> reservations = new HashSet<>();

    private ReservationService() {}

    public static ReservationService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ReservationService();
        }
        return INSTANCE;
    }

    public IRoom createARoom(String roomNumber, Double price, RoomType roomType) {
        Room room = new Room(roomNumber, price, roomType);
        addRoom(room);
        return room;
    }


    public void addRoom(IRoom room) {
        listOfRooms.add(room);
    }

    public Collection<IRoom> getAllRooms() {
        return listOfRooms;
    }


    public IRoom getARoom(String roomId) {
        for (IRoom room : listOfRooms) {
            if(room.getRoomNumber().equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    // store each parameter (room, checkInDate, checkOutDate in a variable
    // look through my list of reservations
    // if any reservation in that list contains all 3 variables, print a message saying the room is already booked for those dates
    // otherwise, create the reservation and add it to my list of reservations

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        Collection<IRoom> availableRooms = findRooms(checkInDate, checkOutDate);
        if (availableRooms.contains(room)) {
            reservations.add(reservation);
            System.out.println("Reservation Completed");
        } else {
            System.out.println("The room you have selected is not available");
        }

        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        ArrayList<IRoom> noRooms = new ArrayList<>();
        List<IRoom> availableRooms = new ArrayList<>();

        if (checkInDate.before(new Date()) || checkInDate.after(checkOutDate)) {
            System.out.println("Your check-in date occurs in the past");
            return noRooms;
        }

        if (checkInDate.equals(checkOutDate) || checkInDate.after(checkOutDate)) {
            System.out.println("Your check-in date is the same as your check-out date");
            return noRooms;
        }

        for (IRoom room : listOfRooms) {
            boolean isReserved = false;
            for  (Reservation reservation : reservations) {
                if(reservation.getRoom().equals(room)) {
                    if (!checkInDate.before(reservation.getCheckInDate()) && !checkOutDate.before(reservation.getCheckInDate())) { //|| (!checkInDate.after(reservation.getCheckOutDate()) && !checkOutDate.after(reservation.getCheckOutDate()))) {
                        isReserved = true;
                        // if check in date is before the reservation check in date and check out date is before the reservation check in date
                    }
                    if (checkInDate.after(reservation.getCheckOutDate()) && checkOutDate.after(reservation.getCheckOutDate())) {
                        isReserved = false;
                        // if check in date is after reservation check out date and check out date is after reservation check out date
                    }


                }
            }
            if (!isReserved) {
                availableRooms.add(room);
            }

        }
        return availableRooms;
    }


    public Collection<Reservation> getCustomersReservation (Customer customer) {
        List<Reservation> customersReservation = new LinkedList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getCustomer() == customer) {
                customersReservation.add(reservation);
            }
        }
        return customersReservation;
    }

    public void printAllReservation() {
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public Collection<Reservation> getAllReservations() {
        return reservations;
    }





//    for (IRoom room : listOfRooms) {
//
//        if(!reservations.contains(room)) {
//            availableRooms.add(room);
//        } else if (reservations.contains(room)) {
//            break;
//        }
//    }


    // I need a function that take a room and returns all the bookings for that room
}