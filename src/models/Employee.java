package models;

public class Employee {
    private String employeeId;
    private String fullName;
    private int age;
    private String address;

    public Employee() {
    }

    public Employee(String  employeeId, String fullName, int age, String address) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.age = age;
        this.address = address;
    }

    public Employee(String[] strings) {
        this.employeeId = strings[0];
        this.fullName = strings[1];
        this.age = Integer.parseInt(strings[2]);
        this.address = strings[3];
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return employeeId + "," + fullName + ',' + age + "," + address;
    }

    public String showEmployeeInformation() {
        return "Employee's information: {FullName: '"+ fullName + "', age: '" + age + "', address: '" + address + "'}";
    }
}
