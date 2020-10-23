package restaurant.products;

import java.io.Serializable;

public class Products implements Serializable {
    private String product;
    private int quantity;
    private float price;

    public Products() {
    }

    public Products(String product, int quantity, float price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  " product: '" + product + '\'' +
                " quantity: " + quantity+ '\'' +
                " price: " + price;
    }
}
