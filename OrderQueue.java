import java.util.*;

public class OrderQueue {
    private PriorityQueue<Order> vipQueue;
    private Queue<Order> normalQueue;
    private int orderCounter = 1;
    public OrderQueue() {
        vipQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.id));
        normalQueue = new LinkedList<>();
    }
    public void placeOrder(String name, String type, int priority) {
        Order order = new Order(name, type, orderCounter++);

        if (priority == 1) {
            vipQueue.offer(order);
            System.out.println("VIP order placed successfully.");
        } else {
            normalQueue.offer(order);
            System.out.println("Normal order placed successfully.");
        }
    }
    public void prepareOrder() {
        if (!vipQueue.isEmpty()) {
            System.out.println("Preparing VIP Order: " + vipQueue.poll());
        } else if (!normalQueue.isEmpty()) {
            System.out.println("Preparing Normal Order: " + normalQueue.poll());
        } else {
            System.out.println("No orders to prepare.");
        }
    }
    public void viewOrders() {
        if (vipQueue.isEmpty() && normalQueue.isEmpty()) {
            System.out.println("No pending orders.");
            return;
        }

        System.out.println("\n VIP Orders ");
        for (Order o : vipQueue) {
            System.out.println(o);
        }

        System.out.println("\n  Normal Orders ");
        for (Order o : normalQueue) {
            System.out.println(o);
        }
    }

    public void totalOrders() {
        System.out.println("Total orders: " + (vipQueue.size() + normalQueue.size()));
    }
}