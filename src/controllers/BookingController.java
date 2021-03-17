package controllers;

import commons.ReadWriteFile;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingController{
    Scanner scanner = new Scanner(System.in);
    private static final String CUSTOMER_PATH = "D:\\FuramaResort\\src\\data\\Customer.csv";
    private static final String BOOKING_PATH = "D:\\FuramaResort\\src\\data\\Booking,csv";
    private static final String VILLA_PATH = "D:\\FuramaResort\\src\\data\\Villa.csv";
    private static final String HOUSE_PATH = "D:\\FuramaResort\\src\\data\\House.csv";
    private static final String ROOM_PATH = "D:\\FuramaResort\\src\\data\\Room.csv";
    ReadWriteFile read = new ReadWriteFile();
    ReadWriteFile write = new ReadWriteFile();
    CustomerController customerController = new CustomerController();
    public void addNewBooking() {
        VillaController villaController = new VillaController();
        HouseController houseController = new HouseController();
        RoomController roomController = new RoomController();

        List<Customer> customerList = new ArrayList<>(customerController.readFormCustomerCsv());
        int size = customerList.size();
        if (size == 0) {
            System.out.println("Customer's list is empty");
            System.out.println("------------------------");
            return;
        }

        customerController.showCustomerList();
        int choice;
        do {
            choice = choice();
        } while (choice < 1 || choice > size);

        System.out.println("1.Booking Villa. \n" +
                "2.Booking House. \n" +
                "3.Booking Room.\n" +
                "4.Exit.");

        Customer customer = customerList.get(choice - 1);
        customerList.remove(choice - 1);
        write.writeList(customerList, CUSTOMER_PATH, false);

        do {
            choice = choice();
        } while (choice < 1 || choice > 4);

        switch (choice) {
            case 1:
                List<Villa> villaList = new ArrayList<>(villaController.showVillaList());
                booking(customer, villaList, VILLA_PATH);
                break;
            case 2:
                List<House> houseList = new ArrayList<>(houseController.showHouseList());
                booking(customer, houseList, HOUSE_PATH);
                break;
            case 3:
                List<Room> roomList = new ArrayList<>(roomController.showRoomList());
                booking(customer, roomList, ROOM_PATH);
                break;
            case 4:
                System.exit(0);
        }
    }

    public void booking(Customer customer, List<? extends Service> list, String PATH) {
        int size = list.size();
        if (size == 0) {
            System.out.println("List is empty");
            System.out.println("------------------------");
            return;
        }

        int choice;
        do {
            choice = choice();
        } while (choice < 1 || choice > size);
        customer.setService(list.get(choice - 1));
        write.write(customer, BOOKING_PATH, true);
        list.remove(choice - 1);
        write.writeList(list, PATH, false);
    }

    int choice() {
        int choice;
        do {
            System.out.println("Input your choice (do not out of range's list) :");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Please , input a integer do not out of range's list");
            }
        } while (true);
        return choice;
    }
}
