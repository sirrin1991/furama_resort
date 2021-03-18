package controllers;

import commons.ReadWriteFile;
import commons.Validation;
import models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BookingController {
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
            String tempChoice = scanner.nextLine();
            if (Validation.validateChoice(tempChoice)) {
                choice = Integer.parseInt(tempChoice);
                break;
            }
        } while (true);
        return choice;
    }

    public List<Customer> showBookingList() {
        List<String[]> list = new ArrayList<>(read.read(BOOKING_PATH));
        List<Customer> customerList = new ArrayList<>();
        if (list.size() == 0) {
            System.out.println("Booking's list is empty");
            System.out.println("----------------------------");
            return customerList;
        }
        System.out.println("------------------------------");
        for (String[] strings : list) {
            if (strings.length == 18) {
                Villa villa = new Villa();
                villa.setServiceCode(strings[8]);
                villa.setServiceName(strings[9]);
                villa.setUsableArea(Double.parseDouble(strings[10]));
                villa.setRentalCost(Double.parseDouble(strings[11]));
                villa.setMaxAmountPeople(Integer.parseInt(strings[12]));
                villa.setRentalType(strings[13]);
                villa.setRoomStandard(strings[14]);
                villa.setOtherConvenient(strings[15]);
                villa.setPoolArea(Double.parseDouble(strings[16]));
                villa.setNumberOfFloors(Integer.parseInt(strings[17]));
                Customer customer = new Customer(strings, villa);
                customerList.add(customer);
            }

            if (strings.length == 17) {
                House house = new House();
                house.setServiceCode(strings[8]);
                house.setServiceName(strings[9]);
                house.setUsableArea(Double.parseDouble(strings[10]));
                house.setRentalCost(Double.parseDouble(strings[11]));
                house.setMaxAmountPeople(Integer.parseInt(strings[12]));
                house.setRentalType(strings[13]);
                house.setRoomStandard(strings[14]);
                house.setOtherConvenient(strings[15]);
                house.setNumberOfFloors(Integer.parseInt(strings[16]));
                Customer customer = new Customer(strings, house);
                customerList.add(customer);
            }

            if (list.get(0).length == 15) {
                Room room = new Room();
                room.setServiceCode(strings[8]);
                room.setServiceName(strings[9]);
                room.setUsableArea(Double.parseDouble(strings[10]));
                room.setRentalCost(Double.parseDouble(strings[11]));
                room.setMaxAmountPeople(Integer.parseInt(strings[12]));
                room.setRentalType(strings[13]);
                room.setFreeService(strings[14]);
                Customer customer = new Customer(strings, room);
                customerList.add(customer);
            }
        }
        for(int i = 0 ; i < customerList.size();i++){
            System.out.println((i+1) +". " + customerList.get(i).showInformationCustomer());
        }
        System.out.println("------------------------------");
        return customerList;
    }

}
