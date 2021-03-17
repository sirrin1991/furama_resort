package controllers;

import commons.ReadWriteFile;
import commons.Validation;
import models.Employee;

import java.util.*;

public class EmployeeController {
    private static final String EMPLOYEE_PATH = "D:\\FuramaResort\\src\\data\\Employee.csv";
    Scanner scanner = new Scanner(System.in);

    public void addNewEmployee() {
        String iD;
        String fullName;
        int age;
        String address;

        do {
            System.out.println("Employee's ID :");
            iD = scanner.nextLine();
        } while (!Validation.validateEmployeeId(iD));

        do {
            System.out.println("Employee's Name :");
            fullName = scanner.nextLine();
        } while (!Validation.validateAllName(fullName));

        do {
            System.out.println("Employee's age :");
            String temp = scanner.nextLine();
            if (Validation.validateEmployeeAge(temp)) {
                age = Integer.parseInt(temp);
                break;
            }
        } while (true);

        do {
            System.out.println("Employee's address :");
            address = scanner.nextLine();
        } while (address == null);
        Employee employee = new Employee(iD, fullName, age, address);
        writeToEmployeeCsv(employee);
    }

    public void showEmployeeList() {
        Map<String, Employee> employeeMap = new TreeMap<>(readFromEmployeeCsv());
        System.out.println("-------------------------");
        for (Map.Entry<String, Employee> entry : employeeMap.entrySet()) {
            System.out.println("Employee's ID =" + entry.getKey() + " " + entry.getValue().showEmployeeInformation());
        }
        System.out.println("-------------------------");
    }

    public void writeToEmployeeCsv(Employee employee) {
        ReadWriteFile write = new ReadWriteFile();
        write.write(employee, EMPLOYEE_PATH, true);
    }

    public Map<String, Employee> readFromEmployeeCsv() {
        ReadWriteFile read = new ReadWriteFile();
        List<String[]> strings = new ArrayList<>(read.read(EMPLOYEE_PATH));
        Map<String, Employee> employeeMap = new TreeMap<>();
        for (String[] str : strings) {
            Employee employee = new Employee(str);
            employeeMap.put(employee.getEmployeeId(), employee);
        }
        return employeeMap;
    }

    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController();
        employeeController.showEmployeeList();
    }
}
