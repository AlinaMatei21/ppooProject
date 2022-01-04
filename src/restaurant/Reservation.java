package restaurant;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Reservation implements Serializable {
    private String id;
    private Locations location;
    private Date date;
    private String name;
    private int noPeople;


    public Reservation(Locations location, Date date, String name, int noPeople) {
        this.id = UUID.randomUUID().toString();
        this.location = location;
        this.date = date;
        this.name = name;
        this.noPeople = noPeople;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoPeople() {
        return noPeople;
    }

    public void setNoPeople(int noPeople) {
        this.noPeople = noPeople;
    }

    @Override
    public String toString() {
        return "Reservation \n " +
                " id: " + id +
                ", location: '" + location + '\'' +
                ", date: " + date +
                ", name: '" + name + '\'' +
                ", noPeople: " + noPeople;
    }

    public void reservationFee(){
        int fee = 0;
        if(noPeople < 4){
            fee = 50;
            System.out.println("A fee of " + fee +" lei will be encountered because there are only " + noPeople + " people");
        }
        else
            System.out.println("No fee is added.");
    }
}
