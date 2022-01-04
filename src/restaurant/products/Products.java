package restaurant.products;

import java.io.Serializable;

public class Products implements Serializable{
    private String product;
    private float price;

    public Products() {
    }

    public Products(String product, float price) {
        this.product = product;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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
                " price: " + price;
    }
}
