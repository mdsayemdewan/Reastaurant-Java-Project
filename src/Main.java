import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuAbs menu = new Menubar(); 
        Order order = new Order(menu.getFoodList()); 
        Scanner scanner = new Scanner(System.in);

        final String STAFF_USERNAME = "staff567";
        final String STAFF_PASSWORD = "sta123@";

        int choice;
        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Staff");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Only For Staff
                    scanner.nextLine(); 
                    System.out.print("Enter Staff Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Staff Password: ");
                    String password = scanner.nextLine();

                    if (username.equals(STAFF_USERNAME) && password.equals(STAFF_PASSWORD)) {
                        System.out.println("Login successful! Welcome, Staff.");

                        int staffChoice;
                        do {
                            System.out.println("\nStaff Menu:");
                            System.out.println("1. Add Food");
                            System.out.println("2. Update Food");
                            System.out.println("3. Delete Food");
                            System.out.println("4. Display Food");
                            System.out.println("5. Confirm Payment");
                            System.out.println("6. Return to Main Menu");
                            System.out.print("Enter your choice: ");
                            staffChoice = scanner.nextInt();

                            switch (staffChoice) {
                                case 1:
                                    menu.addFood(); //add the food
                                    break;
                                case 2:
                                    menu.updateFood(); //update the food
                                    break;
                                case 3:
                                    menu.deleteFood(); //delete the food
                                    break;
                                case 4:
                                    menu.displayFoods(); //display the food
                                    break;
                                case 5:
                                    // It is for confirm payment
                                    scanner.nextLine(); 
                                    System.out.print("Enter Customer Name: ");
                                    String customerName = scanner.nextLine();
                                    System.out.print("Enter Amount: ");
                                    double amount = scanner.nextDouble();

                                    StaffConfirmation staffConfirmation = new StaffConfirmation();
                                    staffConfirmation.confirmBill(customerName, amount);

                                    if (staffConfirmation.isBillPaid()) {
                                        System.out.println("Payment successfully confirmed for " + customerName);
                                    } else {
                                        System.out.println("Payment confirmation failed.");
                                    }
                                    break;
                                case 6:
                                    System.out.println("Return to Main Menu. ");
                                    break;
                                default:
                                    System.out.println("Please Try again.");
                            }
                        } while (staffChoice != 6);

                    } else {
                        System.out.println("Invalid username or password. Return to Main Menu. ");
                    }
                    break;

                case 2:
                    // It is for Customer Order
                    scanner.nextLine(); 
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Are you a student? (yes/no): ");
                    String isStudent = scanner.nextLine();

                    Customer customer;
                    if (isStudent.equalsIgnoreCase("yes")) {
                        customer = new Student(name);
                    } else {
                        customer = new RegularCustomer(name);
                    }

                    double totalAmount = order.placeOrder(customer);

                    if (totalAmount > 0) {
                        System.out.println("\nThank you for your order=  " + name );
                        System.out.println("Your total amount is: " + totalAmount +"TK");
                    }
                    break;

                case 3:
                    System.out.println("Exit..");
                    break;

                default:
                    System.out.println("Invalid choice.Please Try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
