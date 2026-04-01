public class Order {
    String name;
    String type; // Normal / Takeaway
    int id;

    public Order(String name, String type, int id) {
        this.name = name;
        this.type = type;
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Order: " + name + ", Type: " + type;
    }
}