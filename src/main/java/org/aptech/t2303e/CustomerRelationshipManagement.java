package org.aptech.t2303e;
import java.util.*;
    public class CustomerRelationshipManagement {
        private static final HashMap<String, Customer> customers = new HashMap<>();

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Add new customer");
                System.out.println("2. Find by name");
                System.out.println("3. Display all");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        addCustomer(scanner);
                        break;
                    case 2:
                        findCustomer(scanner);
                        break;
                    case 3:
                        displayAllCustomers();
                        break;
                    case 4:
                        System.err.println("Exiting the application...");
                        System.exit(0);
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            }
        }


        private static void addCustomer(Scanner scanner) {
            System.err.print("Enter name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                return;
            }
            System.err.print("Enter email: ");
            String email = scanner.nextLine();
            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                System.out.println("Invalid email format.");
                return;
            }
            System.err.print("Enter phone number: ");
            String phoneNumber = scanner.nextLine();
            if (!phoneNumber.matches("^\\d{10}$")) {
                System.out.println("Invalid phone number. It should be 10 digits.");
                return;
            }
            customers.put(name, new Customer(name, email, phoneNumber));
            System.err.println("Customer added successfully!");
        }

        private static void findCustomer(Scanner scanner) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            Customer customer = customers.get(name);
            if (customer != null) {
                System.out.println(customer);
            } else {
                System.out.println("Not found");
            }
        }

        private static void displayAllCustomers() {
            System.out.println("CRM");

            System.out.println("Name\t\tPhone number\t\tEmail");

            for (Customer customer : customers.values()) {
                System.out.println(customer.name + "\t\t" + customer.phoneNumber +"\t\t" + customer.email);
            }
        }
    }
