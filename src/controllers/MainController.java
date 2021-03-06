package controllers;

import commons.Validation;

import java.util.Scanner;

public class MainController {
    Scanner scanner = new Scanner(System.in);
    CustomerController customerController = new CustomerController();
    VillaController villaController = new VillaController();
    HouseController houseController = new HouseController();
    RoomController roomController = new RoomController();
    EmployeeController employeeController = new EmployeeController();
    BookingController bookingController = new BookingController();
    CinemaController cinemaController = new CinemaController();
    EmployeeProfileStack employeeProfileStack = new EmployeeProfileStack();

    public void displayMainMenu() {
        do {
            System.out.println("Main Menu :\n" +
                    "1.Add New Services\n" +
                    "2.Show Services\n" +
                    "3.Add New Customer\n" +
                    "4.Show Information of Customer\n" +
                    "5.Add New Booking\n" +
                    "6.Show Booking List\n" +
                    "7.Employee Management\n" +
                    "8.Cinema 4D\n" +
                    "9.Search Employee'profile by fullname\n" +
                    "10.Exit");
            int choice = choice();
            switch (choice) {
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showService();
                    break;
                case 3:
                    customerController.addNewCustomer();
                    break;
                case 4:
                    customerController.showCustomerList();
                    break;
                case 5:
                    bookingController.addNewBooking();
                    break;
                case 6:
                    bookingController.showBookingList();
                    break;
                case 7:
                    employeeManagement();
                    break;
                case 8:
                    displayCinemaMenu();
                    break;
                case 9:
                    employeeProfileStack.searchEmployeeProfile();
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("---Out of range (1 -> 7), try again ---");

            }
        } while (true);
    }

    public void addNewServices() {
        System.out.println("1.Add New Villa\n" +
                "2.Add New House\n" +
                "3.Add New Room\n" +
                "4.Back to menu\n" +
                "5.Exit");
        int choice = choice();
        switch (choice) {
            case 1:
                villaController.addNewVilla();
                break;
            case 2:
                houseController.addNewHouse();
                break;
            case 3:
                roomController.addNewRoom();
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                System.out.println("------GOOD BYE------");
                System.exit(0);
            default:
                System.out.println("---Input out of range (1 -> 5),try again---");
                addNewServices();
        }
    }

    public void showService() {
        System.out.println("1.Show all Villa\n" +
                "2.Show all House\n" +
                "3.Show all Room\n" +
                "4.Show All Name Villa Not Duplicate\n" +
                "5.Show All Name House Not Duplicate\n" +
                "6.Show All Name Name Not Duplicate\n" +
                "7.Back to menu\n" +
                "8.Exit");
        int choice = choice();
        switch (choice) {
            case 1:
                villaController.showVillaList();
                break;
            case 2:
                houseController.showHouseList();
                break;
            case 3:
                roomController.showRoomList();
                break;
            case 4:
                villaController.showVillaListNotDuplicate();
                break;
            case 5:
                houseController.showHouseListNotDuplicate();
                break;
            case 6:
                roomController.showRoomListNotDuplicate();
                break;
            case 7:
                displayMainMenu();
                break;
            case 8:
                System.exit(0);
            default:
                System.out.println("---Input out of range (1 -> 8),try again---");
                showService();
        }
    }

    int choice() {
        int choice;
        do {
            System.out.println("Input your choice (do not out of range's list) :");
            String tempChoice = scanner.nextLine();
            if (Validation.validateChoice(tempChoice)) {
                choice = Integer.parseInt(tempChoice);
                break;
            }
        } while (true);
        return choice;
    }

    public void employeeManagement() {
        System.out.println("1.Add New Employee\n" +
                "2.Show Employee's list\n" +
                "3.Back To Main Menu\n" +
                "4.Exit");
        int choice;
        do {
            choice = choice();
        } while (choice < 1 || choice > 4);
        switch (choice) {
            case 1:
                employeeController.addNewEmployee();
                break;
            case 2:
                employeeController.showEmployeeMap();
                break;
            case 3:
                displayMainMenu();
                break;
            case 4:
                System.exit(0);
        }
    }

    public void displayCinemaMenu() {
        System.out.println("1.Sell Ticket\n" +
                "2.Reset for next time\n" +
                "3.Back to menu\n" +
                "4.Exit");
        int choice;
        do {
            choice = choice();
        } while (choice < 1 || choice > 4);
        switch (choice){
            case 1:
                cinemaController.sellTicket();
                break;
            case 2:
                cinemaController.resetTicket();
                break;
            case 3:
                displayMainMenu();
                break;
            case 4:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }
}
