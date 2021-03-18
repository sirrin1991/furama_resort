package controllers;

import commons.Validation;
import models.Employee;

import java.util.Scanner;
import java.util.Stack;

public class EmployeeProfileStack {
    EmployeeController employeeController = new EmployeeController();

    public void searchEmployeeProfile() {
        int count=0;
        Stack<Employee> employeeStack = new Stack<>();
        employeeStack.addAll(employeeController.readEmployeeCsv());
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Employee's FullName need to search :");
        do{
            name = scanner.nextLine();
        }while (!Validation.validateAllName(name));
        for (Employee employee : employeeStack) {
            if (name.equals(employee.getFullName())) {
                System.out.println(employee.showEmployeeInformation());
                count++;
            }
        }
        if(count==0){
            System.out.println("Do not have this employee!!!!");
        }
        System.out.println("-------------------------------");
    }

}
