package controllers;


import java.util.*;

import commons.*;
import models.Customer;

public class CustomerController {
    Scanner scanner = new Scanner(System.in);
    private static final String CUSTOMER_PATH = "D:\\FuramaResort\\src\\data\\Customer.csv";

    public void addNewCustomer() {
        String name;
        String birthDay;
        String gender;
        String iDCard;
        String phone;
        String email;
        String customerType;
        String address;
        do {
            System.out.println("Customer name :");
            name = scanner.nextLine();
        } while (!Validation.validateAllName(name));

        do {
            System.out.println("Customer's birthday :");
            birthDay = scanner.nextLine();

        } while (!Validation.validateBirthDay(birthDay));

        do {
            System.out.println("Customer's gender :");
            gender = scanner.nextLine();
            if (Validation.validateGender(gender)) {
                String[] temp = gender.toLowerCase().split("");
                StringBuilder stringBuilder = new StringBuilder();
                for (byte i = 0; i < temp.length; i++) {
                    if (i == 0) {
                        stringBuilder.append(temp[0].toUpperCase());
                        continue;
                    }
                    stringBuilder.append(temp[i]);
                }
                gender = stringBuilder.toString();
                break;
            }
        } while (true);

        do {
            System.out.println("Customer's ID card :");
            iDCard = scanner.nextLine();
        } while (!Validation.validateIDCard(iDCard));

        do {
            System.out.println("Customer's phone :");
            phone = scanner.nextLine();
        } while (!Validation.validatePhoneNumber(phone));

        do {
            System.out.println("Customer's email :");
            email = scanner.nextLine();
        } while (!Validation.validateEmail(email));

        do {
            System.out.println("Type of customer :");
            customerType = scanner.nextLine();
        } while (!Validation.validateCustomerType(customerType));

        do {
            System.out.println("Customer's address");
            address = scanner.nextLine();
            if (address != null) {
                break;
            }
            System.out.println("Can not empty, try again");
        } while (true);
        Customer customer = new Customer(name, birthDay, gender, iDCard, phone, email, customerType, address);
        writeToCustomerCsv(customer);
    }

    public void showCustomerList() {
        List<Customer> customerList = new ArrayList<>(readFormCustomerCsv());
        Collections.sort(customerList);
        System.out.println("------------------------");
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println("Serial: " + (i + 1) + ".\t" + customerList.get(i).showInformationCustomer());
        }
        System.out.println("------------------------");
    }

    private void writeToCustomerCsv(Customer customer) {
        ReadWriteFile write = new ReadWriteFile();
        write.write(customer, CUSTOMER_PATH, true);
    }

    public List<Customer> readFormCustomerCsv() {
        ReadWriteFile read = new ReadWriteFile();
        List<String[]> list = new ArrayList<>(read.read(CUSTOMER_PATH));
        List<Customer> customerList = new ArrayList<>();
        for (String[] strings : list) {
            Customer customer = new Customer(strings);
            customerList.add(customer);
        }
        return customerList;
    }
}
