import java.util.Scanner;

public class CafeMenu {
    private OrderQueue orderQueue;
    private Scanner sc;

    public CafeMenu() {
        orderQueue = new OrderQueue();
        sc = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;

        do {
            System.out.println("\n  Cafe Order Menu ");
            System.out.println("1. Place New Order");
            System.out.println("2. Prepare Next Order");
            System.out.println("3. View Orders by Priority");
            System.out.println("4. Total Orders");
            System.out.println("5. Exit");

            choice = getValidChoice();

            switch (choice) {
                case 1:
                    placeOrderFlow();
                    break;
                case 2:
                    orderQueue.prepareOrder();
                    break;
                case 3:
                    orderQueue.viewOrders();
                    break;
                case 4:
                    orderQueue.totalOrders();
                    break;
                case 5:
                    System.out.println("Exiting application. Thank you.");
                    break;
            }

        } while (choice != 5);

        sc.close();
    }

    private int getValidChoice() {
        int choice;
        while (true) {
            System.out.print("Enter your choice (1-5): ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
                if (choice >= 1 && choice <= 5) {
                    return choice;
                }
            } else {
                sc.nextLine();
            }
            System.out.println("Invalid choice. Please enter 1 to 5.");
        }
    }
    private void placeOrderFlow() {
    System.out.print("Enter order name: ");
    String order = sc.nextLine();

    String type;
    while (true) {
        System.out.print("Enter order type (Normal / Takeaway): ");
        type = sc.nextLine();
        if (type.equalsIgnoreCase("Normal") || type.equalsIgnoreCase("Takeaway")) {
            break;
        }
        System.out.println("Invalid type. Enter Normal or Takeaway.");
    }

    int priority;
    while (true) {
        System.out.print("Enter priority (1 = VIP, 2 = Normal): ");
        if (sc.hasNextInt()) {
            priority = sc.nextInt();
            sc.nextLine();
            if (priority == 1 || priority == 2) {
                break;
            }
        } else {
            sc.nextLine();
        }
        System.out.println("Invalid priority. Enter 1 or 2.");
    }

    // ✅ ONLY THIS LINE (IMPORTANT)
    orderQueue.placeOrder(order, type, priority);
}
}