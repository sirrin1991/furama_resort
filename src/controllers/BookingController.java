package controllers;

import commons.ReadWriteFile;
import models.Customer;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class BookingController {
    private static final String CUSTOMER_PATH= "D:\\FuramaResort\\src\\data\\Customer.csv";
    ReadWriteFile read = new ReadWriteFile();
    ReadWriteFile write = new ReadWriteFile();
    CustomerController customerController = new CustomerController();
    MainController mainController = new MainController();
    public void addNewBooking(){
        customerController.showCustomerList();
        List<Customer> customerList = new ArrayList<>(read.read(CUSTOMER_PATH));
        System.out.println(customerList.size());
        int choice;
        do {
            choice = mainController.choice();
        } while (choice <= 0 || choice >= customerList.size() + 1);

    }

    public static void main(String[] args) {
        BookingController bookingController = new BookingController();
        bookingController.addNewBooking();
    }
}
