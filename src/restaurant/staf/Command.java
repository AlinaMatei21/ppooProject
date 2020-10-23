package restaurant.staf;

import restaurant.products.Products;

import java.io.Serializable;

public class Command implements IActions, Serializable {
    private int id;
    private String option;
    private String location;
    private Order order;
    private Reservations reservation;

    public Command(String option, String location, Order order, Reservations reservation) {
        this.id++;
        this.option = option;
        this.location = location;
        this.order = order;
        if(this.order != null) {
            order.getProduct();
        }

        this.reservation = reservation;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Reservations getReservation() {
        return reservation;
    }

    public void setReservation(Reservations reservation) {
        this.reservation = reservation;
    }

    @Override
    public void GetOrder() {
        if(option.compareTo("reservation") == 0){
            reservation = new Reservations(reservation.getCustomerName(), reservation.getNoCustomer(), reservation.getDate());
        }
        if(option.compareTo("order") == 0){
            order = new Order(order.getProduct());
        }
    }

    @Override
    public float TotalCost() {
        float total = 0f;
        if(option.equals("reservation")){
           total = reservation.TotalCost();
            return total;
        }
        else if(option.equals("order")) {
            total = order.getProduct().getPrice()*order.getProduct().getQuantity();
            System.out.println( "Total cost for the order: " + total  + " ron");
            return total;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Command id: " + id +
                "\n option: '" + option + '\'' +
                "\n location: '" + location + '\'' +
                "\n order: " + order +
                "\n reservation: " + reservation;
    }
}
