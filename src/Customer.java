public abstract class Customer {
    String name;

    public Customer(String name) {
        this.name = name;
    }

    // calculate the dicount
    public abstract double calculateDiscount(double totalPrice);
}
