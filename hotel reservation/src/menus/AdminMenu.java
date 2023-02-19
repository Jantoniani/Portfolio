package menus;

import api.AdminResource;
import model.RoomType;
import service.ReservationService;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class AdminMenu {
    private static AdminMenu INSTANCE;
    Scanner adminMenuScanner = new Scanner(System.in);
    int adminChoice;
    AdminResource adminApi = AdminResource.getInstance();
    Scanner createRoom = new Scanner(System.in);
    private static Set<Integer> roomNumbers = new HashSet<>();

    private AdminMenu() {}

    public static AdminMenu getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new AdminMenu();
        }
        return INSTANCE;
    }

    public void adminMenu() {

        do {
            System.out.println("1. See all Customers");
            System.out.println("2. See all Rooms");
            System.out.println("3. See all Reservations");
            System.out.println("4. Add a Room");
            System.out.println("5. Back to Main Menu");

            try {
                adminChoice = adminMenuScanner.nextInt();

                switch (adminChoice) {
                    case 1:
                        System.out.println(adminApi.getAllCustomers());
                        break;
                    case 2:
                        System.out.println(adminApi.getAllRooms());
                        break;
                    case 3:
                        adminApi.displayAllReservations();
                        break;
                    case 4:
                        boolean validInput = false;
                        boolean validPrice = false;
                        boolean validRoomType = false;
                        String roomNumber;
                        double price = 0;
                        do {
                            System.out.println("Please enter the Room Number: ");
                            roomNumber = createRoom.next();
                            try {
                                int roomNumberInt = Integer.parseInt(roomNumber);
                                if (roomNumbers.contains(roomNumberInt)) {
                                    System.out.println("Room number already exists. Please try again");
                                } else {
                                    roomNumbers.add(roomNumberInt);
                                    validInput = true;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid Room Number.  Please try again");
                            }
                        } while (!validInput);
                        do {
                            System.out.println("Please enter the Room Price: ");
                            try {
                                price = createRoom.nextDouble();
                                validPrice = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid price. Please try again");
                                createRoom.nextLine();
                            }
                        } while (!validPrice);
                        RoomType roomType = null;
                        do {
                            System.out.println("Is room a Single or a Double?  Press 1 for Single and 2 for Double");
                            try {
                                int room = createRoom.nextInt();
                                if (room == 1) {
                                    roomType = RoomType.SINGLE;
                                    validRoomType = true;
                                } else if (room == 2) {
                                    roomType = RoomType.DOUBLE;
                                    validRoomType = true;
                                } else {
                                    System.out.println("Invalid choice.  Default of Single will be used");
                                    roomType = RoomType.SINGLE;
                                    validRoomType = true;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Please type either 1 or 2");
                                createRoom.nextLine();

                            }
                        } while (!validRoomType);
                        adminApi.createARoom(roomNumber, price, roomType);
                        break;
                    case 5:
                        // Back to Main Menu
                        break;
                    default:
                        System.out.println("Invalid choice, please try again");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please choose from the Menu");
                adminMenuScanner.next();
            }
        } while (adminChoice != 5);
    }
}
