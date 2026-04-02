import java.util.*;

public class OrderQueue {
    private PriorityQueue<Order> vipQueue;
    private Queue<Order> normalQueue;
    private Map<Integer, Order> allOrders;
    private int orderCounter = 1;

    public OrderQueue() {
        vipQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.id));
        normalQueue = new LinkedList<>();
        allOrders = new HashMap<>();
    }

    public void placeOrder(String name, String type, int priority) {
        Order order = new Order(orderCounter++, name, type);
        allOrders.put(order.id, order);

        if (priority == 1) {
            vipQueue.offer(order);
            System.out.println("VIP order placed successfully.");
        } else {
            normalQueue.offer(order);
            System.out.println("Normal order placed successfully.");
        }
    }

    public void prepareOrder() {
        Order order = null;

        if (!vipQueue.isEmpty()) {
            order = vipQueue.poll();
        } else if (!normalQueue.isEmpty()) {
            order = normalQueue.poll();
        }

        if (order == null) {
            System.out.println("No orders to prepare.");
        } else {
            order.setStatus("PREPARING");
            System.out.println("Preparing Order: " + order);
        }
    }

    public void viewOrders() {
        if (allOrders.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }

        System.out.println("\n--- All Orders ---");
        for (Order o : allOrders.values()) {
            System.out.println(o);
        }
    }

    public void updateOrderStatus(int id, String newStatus) {
        Order order = allOrders.get(id);

        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        if (!isValidStatus(newStatus)) {
            System.out.println("Invalid status.");
            return;
        }

        order.setStatus(newStatus);
        System.out.println("Order status updated: " + order);
    }

    private boolean isValidStatus(String status) {
        return status.equalsIgnoreCase("PENDING") ||
               status.equalsIgnoreCase("PREPARING") ||
               status.equalsIgnoreCase("READY") ||
               status.equalsIgnoreCase("COMPLETED");
    }

    public void totalOrders() {
        System.out.println("Total orders: " + allOrders.size());
    }
}