package com.main;

import restaurant.InsertData;
import restaurant.Restaurant;
import restaurant.staf.Order;
import restaurant.staf.Command;
import restaurant.products.Products;
import restaurant.staf.Reservations;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");

        InsertData insertData = new InsertData();
        insertData.ReadData();

        Reservations r1 = new Reservations("Ana", 5, "21.oct.2020 20.30");
        Order o1 = new Order(new Products("soup", 2, 13));

        Command c1 = new Command("reservation", "Magheru", null, r1);
        Command c2 = new Command("order", "Magheru", o1, null);

        c1.TotalCost();
        c2.TotalCost();

        Restaurant<Command> restaurant1 = new Restaurant<Command>("Magheru restaurant");
        restaurant1.add(c1);
        restaurant1.add(c2);
        restaurant1.add(insertData.addOrderToRestaurant());

        restaurant1.getSize();
        restaurant1.show();

        //read files
        //write files
        //console app
        //exceptii


        try {
            FileOutputStream fout = new FileOutputStream("restaurant.txt");
            ObjectOutputStream ous = new ObjectOutputStream(fout);
            ous.writeObject(restaurant1);
            ous.close();
            fout.close();
            System.out.println("The file has been written");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
