package controllers;

import commons.Validation;
import models.Customer;

import java.util.*;

public class CinemaController {
    private int ticket = 5;
    Queue<Customer> customerQueue = new ArrayDeque<>(ticket);

    public void sellTicket() {
        int emptySlot = ticket - customerQueue.size();
        if (emptySlot == 0) {
            System.out.println("Sorry , The Cinema is full");
            System.out.println("-------------------------");
            return;
        }
        System.out.println("The last " + emptySlot + " ticket(s)");
        BookingController bookingController = new BookingController();
        System.out.println("-------------------------");
        List<Customer> customerList = new ArrayList<>(bookingController.showBookingList());
        System.out.println("-------------------------");
        int choice;

        do {
            choice = choice();
        } while (choice < 1 || choice > customerList.size());

        customerQueue.offer(customerList.get(choice - 1));
        if (customerQueue.size() == ticket) {
            System.out.println("Customer's list have ticket(s) :");
            System.out.println("-------------------------");
            for (Customer customer : customerQueue) {
                System.out.println(customer.showInformationCustomer());
            }
            System.out.println("-------------------------");
        }
    }

    public void resetTicket() {
        customerQueue.clear();
        System.out.println("----------DONE----------");
    }

    int choice() {
        Scanner scanner = new Scanner(System.in);
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

}
