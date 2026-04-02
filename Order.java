public class Order {
    int id;
    String name;
    String type;
    String status;

    public Order(int id, String name, String type) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.status = "PENDING"; // default status
    
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public String toString() {
        return "ID: " + id + ", Order: " + name + ", Type: " + type + ", Status: " + status;
    }
}