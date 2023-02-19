package menus;
import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.IRoom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner dateScanner = new Scanner(System.in);
        Scanner getResScanner = new Scanner(System.in);
        Scanner createAccScanner = new Scanner(System.in);
        Scanner bookingScanner = new Scanner(System.in);

        int choice = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        HotelResource hotelApi = HotelResource.getInstance();
        AdminMenu admin  = AdminMenu.getInstance();



        do {
            System.out.println("1. Find and reserve a room");
            System.out.println("2. See my reservations");
            System.out.println("3. Create an account");
            System.out.println("4. Admin");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");


            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Please enter your check-in date (dd/MM/yyyy):");
                        String checkInInput = dateScanner.nextLine();
                        Date checkIn = null;
                        try {
                            checkIn = dateFormat.parse(checkInInput);
                        } catch (ParseException e) {
                            System.out.println("Invalid date format.");
                        }

                        System.out.println("Please enter your check-out date (dd/MM/yyyy):");
                        String checkOutInput = dateScanner.nextLine();
                        Date checkOut = null;
                        try {
                            checkOut = dateFormat.parse(checkOutInput);
                        } catch (ParseException e) {
                            System.out.println("Invalid date format.");
                        }

                        Collection<IRoom> results = null;
                        if (checkIn != null && checkOut != null) {
                            //System.out.println(hotelApi.findARoom(checkIn, checkOut));
                            results = hotelApi.findARoom(checkIn, checkOut);
                        }


                        if (!results.isEmpty()) {
                            System.out.println(results);
                            System.out.println("Would you like to book a room? Please type Y or N: ");
                            String bookingAnswer = bookingScanner.nextLine();
                            if (bookingAnswer.equals("Y")) {
                                System.out.println("Please enter your e-mail: ");
                                String email = bookingScanner.nextLine();
                                Customer customer = hotelApi.getCustomer(email);

                                if (customer == null) {
                                    System.out.println("You have not created an account yet");
                                } else {
                                    System.out.println("What room number would you like to book? ");
                                    String roomNumber = bookingScanner.nextLine();
                                    IRoom room = hotelApi.getRoom(roomNumber);
                                    if (room == null) {
                                        System.out.println("This room does not exist");
                                    } else {
                                        hotelApi.bookARoom(email, room, checkIn, checkOut);
                                        //System.out.println("Reservation Completed!");
                                    }
                                }
                            } else if (bookingAnswer.equals("N")) {
                                break;

                            } else {
                                System.out.println("Invalid Selection");
                            }
                        } else if (results.isEmpty()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(checkIn);
                            calendar.add(Calendar.DATE, 7);
                            checkIn = calendar.getTime();

                            calendar.setTime(checkOut);
                            calendar.add(Calendar.DATE, 7);
                            checkOut = calendar.getTime();

                            System.out.println("No rooms were available for the date you chose");
                            System.out.println("Performing additional search");
                            System.out.println("Searching for check-in: " + checkIn);
                            System.out.println("Searching for check-out: " + checkOut);

                            Collection <IRoom> extendedResults = hotelApi.findARoom(checkIn, checkOut);

                            if (!extendedResults.isEmpty()) {
                                System.out.println(extendedResults);
                                System.out.println("Would you like to book a room? Please type Y or N: ");
                                String bookingAnswer = bookingScanner.nextLine();
                                if (bookingAnswer.equals("Y")) {
                                    System.out.println("Please enter your e-mail: ");
                                    String email = bookingScanner.nextLine();
                                    Customer customer = hotelApi.getCustomer(email);

                                    if (customer == null) {
                                        System.out.println("You have not created an account yet");
                                    } else {
                                        System.out.println("What room number would you like to book? ");
                                        String roomNumber = bookingScanner.nextLine();
                                        IRoom room = hotelApi.getRoom(roomNumber);
                                        if (room == null) {
                                            System.out.println("This room does not exist");
                                        } else {
                                            hotelApi.bookARoom(email, room, checkIn, checkOut);
                                            //System.out.println("Reservation Completed!");
                                        }
                                    }
                                } else if (bookingAnswer.equals("N")) {
                                    break;

                                } else {
                                    System.out.println("Invalid Selection");
                                }
                            } else if (extendedResults.isEmpty()) {
                                System.out.println("Sorry, the additional search also returned no results");
                            }
                        }


                            // If no rooms are found then this code should return a message to the user
                            // that no rooms were found.  Might need to update findARoom to include that

                            // If no rooms are found then user should get a message
                            // If rooms are found then user should get option to make a reservation


                            break;
                            case 2:
                                System.out.println("Please enter your email: ");
                                String email = getResScanner.nextLine();
                                System.out.println(hotelApi.getCustomersReservations(email));
                                // Should probably have something here to check for valid email
                                // Should probably update getCustomersReservations to include a message if no
                                // reservations are found
                                break;
                            case 3:
                                System.out.println("Please enter your email: ");
                                String emailAccount = createAccScanner.nextLine();
                                System.out.println("Please enter your fist name: ");
                                String firstName = createAccScanner.nextLine();
                                System.out.println("Please enter your last name: ");
                                String lastName = createAccScanner.nextLine();

                                hotelApi.createACustomer(emailAccount, firstName, lastName);

                                // Should there be code here to tell a user if their account already exists
                                // If they try to make one when they already have one?

                                break;
                            case 4:
                                admin.adminMenu();
                                break;
                            case 5:
                                System.out.println("Exiting....");
                                break;
                            default:
                                System.out.println("Invalid choice, try again");
                        }
                } catch (Exception e) {
                System.out.println("Invalid input.  Please choose from the Menu");
                scanner.nextLine();
            }
        } while (choice != 5);

        scanner.close();
    }
}
