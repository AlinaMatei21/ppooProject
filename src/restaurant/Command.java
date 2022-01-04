package restaurant;


import restaurant.products.Products;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Command implements Serializable {
    private String id;
    private List<Products> products = null;
    private int quantity;
    private Locations location;

    public Command(List<Products> products, int quantity, Locations location) {
        super();
        this.id = UUID.randomUUID().toString();
        this.products = products;
        this.quantity = quantity;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List getProducts() {
        return products;
    }

    public void setProducts(List products) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Command \n" +
                " id: " + id +
                ", products: " + products +
                ", quantity: " + quantity +
                ", location: '" + location + "'";
    }

    public void totalCost(){
        float total = 0f;
        for (Products p: products) {
            float totall = p.getPrice() * quantity;
            System.out.println("Total cost: " + totall + " " + p.getProduct());
        }

        for (Products p: products) {
            total += p.getPrice() * quantity;
        }

        System.out.println("_______________");
        System.out.println("Total: " + total);

    }

}
