package restaurant.staf;

import restaurant.products.Products;

import java.io.Serializable;

public class Order implements IActions, Serializable {
    private int orderId = 0;
    private Products product;

    public Order(Products product) {
        orderId++;
        this.product = product;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        orderId = orderId;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order" + orderId +
                " \n" + product;
    }

    @Override
    public void GetOrder() {
        System.out.println("The order: "+ orderId + "\n"+
                            product.toString());
    }

    @Override
    public float TotalCost() {
        return product.getQuantity()*product.getPrice();
    }
}
