package models;

import java.util.Comparator;

public class Customer implements Comparable<Customer> {
    private String fullName;
    private String birthDay;
    private String gender;
    private String iDCard;
    private String phoneNumber;
    private String email;
    private String customerType;
    private String address;
    private Service service;

    public Customer() {

    }

    public Customer(String fullName, String birthDay, String gender,
                    String iDCard, String phoneNumber, String email, String customerType, String address) {
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.gender = gender;
        this.iDCard = iDCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(String fullName, String birthDay, String gender,
                    String iDCard, String phoneNumber, String email, String customerType, String address, Service service) {
        this(fullName, birthDay, gender,
                iDCard, phoneNumber, email, customerType, address);
        this.service = service;
    }

    public Customer(String[] strings) {
        this.fullName = strings[0];
        this.birthDay = strings[1];
        this.gender = strings[2];
        this.iDCard = strings[3];
        this.phoneNumber = strings[4];
        this.email = strings[5];
        this.customerType = strings[6];
        this.address = strings[7];
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIDCard() {
        return iDCard;
    }

    public void setIDCard(String iDCard) {
        this.iDCard = iDCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getName() {
        String[] stringName = this.fullName.split(" ");
        return stringName[stringName.length - 1];
    }

    public String getYear() {
        String[] stringYear = this.birthDay.split("/");
        return stringYear[stringYear.length - 1];
    }

    @Override
    public String toString() {
        String string = fullName + ',' + birthDay + "," + gender + "," + iDCard + "," +
                phoneNumber + "," + email + "," + customerType + "," + address;
        if (service != null) {
            string += "," + service.toString();
        }
        return string;
    }

    public String showInformationCustomer() {
        return  "Customer{" +
                "fullName='" + fullName + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", gender='" + gender + '\'' +
                ", iDCard='" + iDCard + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                ", service='" + service +
                "'}";
    }

    @Override
    public int compareTo(Customer o) {
        int result = this.getName().compareTo(o.getName());
        if (result == 0) {
            return this.getYear().compareTo(o.getYear());
        }
        return result;
    }
}
