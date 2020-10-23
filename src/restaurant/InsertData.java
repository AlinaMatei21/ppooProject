package restaurant;

import restaurant.exceptions.InvalidFormatException;
import restaurant.products.Products;
import restaurant.staf.Command;
import restaurant.staf.Order;
import restaurant.staf.Reservations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertData {
    Command command;
    Order o;
    Reservations r;

    public void ReadData(){

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String location = null;
        String option = null;
        String productOption = null;
        String productName = null;
        int quantity = 0;
        float price = 0f;

        String customerName;
        int customersNumber;
        String date = null;

        try {
            System.out.println("Which location would you prefer? Magheru, Victoriei, Dambovita");
            location = reader.readLine();
            System.out.println("Would you like to order or to make a reservation?");
            option = reader.readLine();
            if(option.equals("order")){
                System.out.println("What would you like to order? FOOD, DRINKS or DESERT?");
                productOption = reader.readLine();
                switch(productOption){
                    case "FOOD":
                        System.out.println( "We have the following foods: Soup, Beef, Burge, Fish, Fries, Salad");
                        productName = reader.readLine();
                        break;
                    case "DRINKS":
                        System.out.println( "We have the following drinks: Coffee, Beer, Lemonade, Orange juice, Sparkling water, Wine");
                        productName = reader.readLine();
                        break;
                    case "DESERT":
                        System.out.println( "We have the following deserts: Cheese cake, Lava cake, Pancakes, Biscuits cake, Ice cream, Fruit Salad");
                        productName = reader.readLine();
                        break;
                    default:
                        try {
                            throw new InvalidFormatException();
                        } catch (InvalidFormatException e) {
                            e.printStackTrace();
                        }
                }
                System.out.println("For how many persons? ");
                quantity = Integer.parseInt(reader.readLine());
                System.out.println("The price is: ");
                price = Float.parseFloat(reader.readLine());

                Products products = new Products(productName, quantity, price);
                o = new Order(products);
                command = new Command(option, location, o, r);
                command.TotalCost();

            }else if(option.equals("reservation")){
                System.out.println("On which name would the reservation be?");
                customerName = reader.readLine();
                System.out.println("How many people will come?");
                customersNumber = Integer.parseInt(reader.readLine());
                System.out.println("Let us know the date and time");
                date = reader.readLine();

                r = new Reservations(customerName, customersNumber, date);

                command = new Command(option, location, o, r);
                command.TotalCost();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    public Command addOrderToRestaurant(){
        return command;
    }
}
