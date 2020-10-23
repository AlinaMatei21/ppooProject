package restaurant.staf;

import java.io.Serializable;

public class Reservations implements IActions, Serializable {
    private String customerName;
    private int noCustomer;
    private String date;
    private int fee;

    public Reservations(String customerName, int noCustomer, String date) {
        this.customerName = customerName;
        this.noCustomer = noCustomer;
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNoCustomer() {
        return noCustomer;
    }

    public void setNoCustomer(int noCustomer) {
        this.noCustomer = noCustomer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFee() {
        if (noCustomer < 4) {
            fee = 50;
            System.out.println("There are less than 4 customers, a fee of " + fee + " lei will be encountered");
            return fee;
        } else{
            System.out.println("No fees encountered.");
            return fee;
        }
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return  customerName +
                " wants a table for: " + noCustomer + " at " + date;
    }

    @Override
    public void GetOrder() {
        System.out.println("A reservation for: " + noCustomer +" is done.");
    }

    @Override
    public float TotalCost() {
        return getFee();
    }
}
