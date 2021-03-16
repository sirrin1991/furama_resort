package controllers;

import java.util.Scanner;

public class MainController {
    Scanner scanner = new Scanner(System.in);
    VillaController villaController = new VillaController();
    HouseController houseController = new HouseController();
    RoomController roomController = new RoomController();
    CustomerController customerController = new CustomerController();
    public void displayMainMenu() {
        do {
            System.out.println("Main Menu :\n" +
                    "1.Add New Services\n" +
                    "2.Show Services\n" +
                    "3.Add New Customer\n" +
                    "4.Show Information of Customer\n" +
                    "5.Add New Booking\n" +
                    "6.Show Information of Employee\n" +
                    "7.Exit");
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
                case 7:
                    System.out.println("------GOOD BYE------");
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
            System.out.println("Input your choice (do not out of range's list)");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Please , input a integer do not out of range's list");
            }
        } while (true);
        return choice;
    }

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }
}
