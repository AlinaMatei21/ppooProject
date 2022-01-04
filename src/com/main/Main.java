package com.main;

import restaurant.Locations;
import restaurant.Restaurant;
import restaurant.Command;
import restaurant.exceptions.CommandFailedException;
import restaurant.exceptions.InvalidFormatException;
import restaurant.products.Products;
import restaurant.Reservation;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, CommandFailedException, InvalidFormatException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Products> p1 = new ArrayList<>();
        p1.add(new Products("beef", 45));

        List<Products> p2 = new ArrayList<>();
        p2.add(new Products("beer", 10));

        List<Products> p3 = new ArrayList<>();
        p3.add(new Products("lava cake", 15));

        Command command1 = new Command(p1, 2, Locations.Magheru);
        Command command2 = new Command(p2, 2, Locations.Victoriei );
        Command command3 = new Command(p3, 2, Locations.Universitate );

        Reservation reservation1 = new Reservation(Locations.Magheru, new Date(2020, 11, 19), "Cristiana", 3);
        Reservation reservation2 = new Reservation(Locations.Universitate, new Date(2020, 11, 20), "Alina", 2);
        Reservation reservation3 = new Reservation(Locations.Victoriei, new Date(2020, 11, 21), "Matei", 5);

        Restaurant Magheru = new Restaurant(Locations.Magheru);
        Restaurant Victoriei = new Restaurant(Locations.Victoriei);
        Restaurant Universitate = new Restaurant(Locations.Universitate);

        Magheru.add(command1);
        Magheru.add(reservation1);

        Universitate.add(command3);
        Universitate.add(reservation2);

        Victoriei.add(command2);
        Victoriei.add(reservation3);

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(Magheru);
        restaurants.add(Victoriei);
        restaurants.add(Universitate);

        Reservation reservation = null;
        Command command = null;

        String response = null;
        do {
            System.out.println("Hello");

            String[] availableChoices = {
                    "exit",
                    "add",
                    "remove",
                    "show",
                    "generate report",
                    "print report"
            };

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Available commands:\n");
            for (String choice: availableChoices) {
                stringBuilder.append("    - " + choice + "\n");
            }

            System.out.println(stringBuilder.toString());

            do{
                try {
                    response = reader.readLine();
                    switch(response){
                        case "exit":
                            System.out.println("Bye - Bye");
                            break;
                        case "add":
                            System.out.println("Do you want to make a reservation or command something?");

                        try {
                            response = reader.readLine();
                            String option = null;
                            int quantity;
                            Products product = null;
                            List<Products> products = new ArrayList<>();
                            if (response.equals("command")) {
                                do {
                                    System.out.println("What would you like to order? FOOD, DRINKS or DESERT?");
                                    option = reader.readLine();
                                    String productName = null;
                                    product = new Products();

                                    switch (option) {
                                        case "food":
                                            System.out.println("We have the following foods: Soup, Beef, Burger, Fish, Fries, Salad");
                                            productName = reader.readLine();
                                            switch (productName) {
                                                case "soup":
                                                    product.setPrice(12f);
                                                    break;
                                                case "beef":
                                                    product.setPrice(45f);
                                                    break;
                                                case "burger":
                                                    product.setPrice(32f);
                                                    break;
                                                case "fish":
                                                    product.setPrice(40f);
                                                    break;
                                                case "fries":
                                                    product.setPrice(12f);
                                                    break;
                                                case "salad":
                                                    product.setPrice(12f);
                                                    break;
                                                default:
                                                    product.setPrice(0f);
                                            }
                                            break;
                                            case "drinks":
                                                System.out.println("We have the following drinks: Coffee, Beer, Lemonade, Orange juice, Sparkling water, Wine");
                                                productName = reader.readLine();
                                                switch (productName) {
                                                    case "coffee":
                                                        product.setPrice(12f);
                                                        break;
                                                    case "beer":
                                                        product.setPrice(10f);
                                                        break;
                                                    case "lemonade":
                                                        product.setPrice(17f);
                                                        break;
                                                    case "orange juice":
                                                        product.setPrice(15f);
                                                        break;
                                                    case "sparkling water":
                                                        product.setPrice(12f);
                                                        break;
                                                    case "wine":
                                                        product.setPrice(15f);
                                                        break;
                                                    default:
                                                        product.setPrice(0f);
                                                }
                                                break;
                                                case "desert":
                                                    System.out.println("We have the following deserts: Cheese cake, Lava cake, Pancakes, Biscuits cake, Ice cream, Fruit Salad");
                                                    productName = reader.readLine();
                                                    switch (productName) {
                                                        case "cheese cake":
                                                            product.setPrice(12f);
                                                            break;
                                                        case "lava cake":
                                                            product.setPrice(15f);
                                                            break;
                                                        case "pancakes":
                                                            product.setPrice(10f);
                                                            break;
                                                        case "biscuits cake":
                                                            product.setPrice(15f);
                                                            break;
                                                        case "ice cream":
                                                            product.setPrice(12f);
                                                            break;
                                                        case "fruit salad":
                                                            product.setPrice(12f);
                                                            break;
                                                        default:
                                                            product.setPrice(0f);
                                                    }
                                                    break;
                                    default:
                                        throw new InvalidFormatException("Invalid format exception");
                                    }

                                    System.out.println("For how many persons? ");
                                    quantity = Integer.parseInt(reader.readLine());

                                    product = new Products(productName, product.getPrice());

                                    System.out.println("Would you like to continue to command?");
                                    response = reader.readLine();
                                    products.add(product);
                                } while (response.equals("yes"));

                                System.out.println("Choose your location: Magheru, Victoriei, Universitate");
                                Locations location = Locations.valueOf(reader.readLine());

                                command = new Command(products, quantity, location);
                                System.out.println(command);

                                command.totalCost();

                                if (command.getLocation().equals(Locations.Magheru)) {
                                    Magheru.add(command);
                                } else if (command.getLocation().equals(Locations.Victoriei)) {
                                    Victoriei.add(command);
                                } else if (command.getLocation().equals(Locations.Universitate)) {
                                    Universitate.add(command);
                                }

                                File file = new File("restaurant.txt");
                                FileWriter fileWriter = new FileWriter(file, false);
                                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                                for(Restaurant restaurant:restaurants){
                                    try {
                                        bufferedWriter.write(String.valueOf(restaurant.getContents()));
                                    }catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                                restaurants.clear();
                                bufferedWriter.close();

                            } else if (response.equals("reservation")) {

                                System.out.println("On which name would the reservation be?");
                                String customerName = reader.readLine();

                                System.out.println("How many people will come?");
                                int customersNumber = Integer.parseInt(reader.readLine());

                                System.out.println("Let us know the date and time(dd-mm-yyyy)");
                                Scanner scanner = new Scanner(System.in);
                                String date = scanner.nextLine();
                                Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
                                System.out.println(date1);

                                System.out.println("In which location should we expect you? Magheru, Victoriei, Universitate");
                                Locations location = Locations.valueOf(reader.readLine());

                                reservation = new Reservation(location, date1, customerName, customersNumber);

                                System.out.println("The reservation has been done: " + reservation);
                                reservation.reservationFee();

                                if (reservation.getLocation().equals(Locations.Magheru)) {
                                    Magheru.add(reservation);
                                } else if (reservation.getLocation().equals(Locations.Victoriei)) {
                                    Victoriei.add(reservation);
                                } else if (reservation.getLocation().equals(Locations.Universitate)) {
                                    Universitate.add(reservation);
                                }

                                File file = new File("restaurant.txt");
                                FileWriter fileWriter = new FileWriter(file, false);
                                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                                for(Restaurant restaurant: restaurants) {
                                    try {
                                        bufferedWriter.write(String.valueOf(restaurant.getContents()));
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                                restaurants.clear();
                                bufferedWriter.close();
                            }

                            Magheru.show();
                            Victoriei.show();
                            Universitate.show();
                         } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                        case "show":
                            try {
                                File file = new File("inputFile.txt");
                                Scanner scanner = new Scanner(file);

                                while (scanner.hasNextLine()) {
                                    for (Restaurant restaurant : restaurants) {
                                        restaurant.add(scanner.nextLine());
                                        restaurant.show();
                                    }
                                }
                            } catch (FileNotFoundException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                            break;
                            case "remove":
                                System.out.println("reservation or command");
                                response = reader.readLine();
                                if(response.equals("reservation")){
                                    for(Restaurant restaurant: restaurants) {
                                        restaurant.remove(restaurants.remove(restaurant.getContents()));
                                        if(restaurant.isEmpty())
                                            System.out.println("No reservations");
                                        restaurant.show();
                                    }
                                }
                                else if(response.equals("command")){
                                    for(Restaurant restaurant: restaurants) {
                                        restaurant.remove(command);
                                        restaurant.show();
                                    }
                                }
                                break;
                            case "generate":
                                for(Restaurant res: restaurants) {
                                    boolean result = res.getContents().contains(new Date(19, 11, 2020));
                                    if(result == false)
                                        System.out.println("There are " + res.getSize() + " in the restaurant\n" + "No commands for the date 19-12-2020");
                                    System.out.println(res.getContents());
                                    System.out.println("============================================================================");

                                }
                                break;
                            case "print":
                                try {
                                    File file = new File("restaurant.txt");
                                    FileWriter fileWriter = new FileWriter(file, false);
                                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                                    for(Restaurant restaurant: restaurants){
                                        try {
                                            restaurant.show();
                                            bufferedWriter.write(String.valueOf(restaurant.getContents()));
                                        } catch (IOException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                    System.out.println("Done");
                                    restaurants.clear();
                                    bufferedWriter.close();
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                                break;
                    }
                    System.out.println("Would you like to exit?");

                    response = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }while(response.equals("no"));

            System.out.println("  - exit stage. Getting back to the menu");
            response = reader.readLine();
        }while(!(response.equals("exit")));

    }
}
