import java.util.*;

public class OrderQueue {
    private Queue<String> highPriorityQueue;
    private Queue<String> normalQueue;

    public OrderQueue() {
        highPriorityQueue = new LinkedList<>();
        normalQueue = new LinkedList<>();
    }
    public void placeOrder(String order, int priority) {
        if (priority == 1) {
            highPriorityQueue.offer(order);
            System.out.println("High priority order placed successfully.");
        } else {
            normalQueue.offer(order);
            System.out.println("Normal order placed successfully.");
        }
    }
    public void prepareOrder() {
        if (!highPriorityQueue.isEmpty()) {
            System.out.println("Preparing (High Priority): " + highPriorityQueue.poll());
        } else if (!normalQueue.isEmpty()) {
            System.out.println("Preparing (Normal): " + normalQueue.poll());
        } else {
            System.out.println("No orders to prepare.");
        }
    }
    public void viewOrders() {
        if (highPriorityQueue.isEmpty() && normalQueue.isEmpty()) {
            System.out.println("No pending orders.");
            return;
        }

        System.out.println("\n--- High Priority Orders ---");
        if (highPriorityQueue.isEmpty()) {
            System.out.println("None");
        } else {
            for (String order : highPriorityQueue) {
                System.out.println(order);
            }
        }

        System.out.println("\n--- Normal Orders ---");
        if (normalQueue.isEmpty()) {
            System.out.println("None");
        } else {
            for (String order : normalQueue) {
                System.out.println(order);
            }
        }
    }
    public void totalOrders() {
        int total = highPriorityQueue.size() + normalQueue.size();
        System.out.println("Total orders waiting: " + total);
    }
}