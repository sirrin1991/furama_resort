package controllers;


import java.util.*;

import commons.*;
import models.Customer;

public class CustomerController {
    Scanner scanner = new Scanner(System.in);
    private static final String CUSTOMER_PATH="D:\\FuramaResort\\src\\data\\Customer.csv";

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
            try {
                name = scanner.nextLine();
                if (Validation.validateCustomerName(name)) {
                    break;
                }
            } catch (NameException e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        do {
            System.out.println("Customer's birthday :");
            birthDay = scanner.nextLine();
            try {
                if (Validation.validateBirthDay(birthDay)) {
                    break;
                }
            } catch (BirthdayException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        do {
            System.out.println("Customer's gender :");
            gender = scanner.nextLine();
            try {
                if (Validation.validateGender(gender)) {
                    String[] temp = gender.toLowerCase().split("");
                    StringBuilder stringBuilder = new StringBuilder();
                    for(byte i = 0 ; i < temp.length ; i++){
                        if(i==0){
                            stringBuilder.append(temp[0].toUpperCase());
                            continue;
                        }
                        stringBuilder.append(temp[i]);
                    }
                    gender = stringBuilder.toString();
                    break;
                }
            } catch (GenderException e) {
                System.out.println(e.getMessage());
            }
        }while (true);

        do{
            System.out.println("Customer's ID card :");
            iDCard = scanner.nextLine();
            try{
                if(Validation.validateIDCard(iDCard)){
                    break;
                }
            } catch (IdCardException e) {
                System.out.println(e.getMessage());
            }
        }while (true);

        do{
            System.out.println("Customer's phone :");
            phone = scanner.nextLine();
            try{
                if(Validation.validatePhoneNumber(phone)){
                    break;
                }
            }catch (PhoneNumberException e){
                System.out.println(e.getMessage());
            }
        }while(true);

        do{
            System.out.println("Customer's email :");
            email = scanner.nextLine();
            try{
                if(Validation.validateEmail(email)){
                    break;
                }
            }catch (EmailException e){
                System.out.println(e.getMessage());
            }
        }while (true);

        do {
            System.out.println("Type of customer :");
            try {
                customerType = scanner.nextLine();
                if (Validation.validateCustomerName(customerType)) {
                    break;
                }
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        do{
            System.out.println("Customer's address");
            address = scanner.nextLine();
            if(address != null){
                break;
            }
            System.out.println("Can not empty, try again");
        }while (true);
        Customer customer = new Customer(name,birthDay,gender,iDCard,phone,email,customerType,address);
        writeToCustomerCsv(customer);
    }

    public void showCustomerList(){
        List<Customer> customerList = new ArrayList<>(readFormCustomerCsv());
        Collections.sort(customerList);
        for(int i = 0 ; i < customerList.size();i++){
            System.out.println("Serial: " + (i+1) + ".\t" + customerList.get(i).showInformationCustomer());
        }
    }

    private void writeToCustomerCsv(Customer customer){
        ReadWriteFile write = new ReadWriteFile();
        write.write(customer,CUSTOMER_PATH,true);
    }

    private List<Customer> readFormCustomerCsv(){
        ReadWriteFile read = new ReadWriteFile();
        List<String[]> list = new ArrayList<>(read.read(CUSTOMER_PATH));
        List<Customer> customerList = new ArrayList<>();
        for(String[] strings:list){
            Customer customer = new Customer(strings);
            customerList.add(customer);
        }
        return customerList;
    }
}

class test {
    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();
        customerController.showCustomerList();

    }
}
