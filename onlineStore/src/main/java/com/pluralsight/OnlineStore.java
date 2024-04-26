package com.pluralsight;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineStore {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        returnHome();
    }

    // return home method, Display home screen to user
    public static void returnHome() {
        ArrayList<Product> products = getInventoryOfProducts();
        System.out.println("Welcome to Binary Buds Online Store! What would you like to do?");
        System.out.println("1: Display all products");
        System.out.println("2: Display Cart");
        System.out.println("3: Exit");
        int choice = input.nextInt();
        while (choice != 3) {
            switch (choice) {
                case 1:
                    displayProducts(products);
                    break;
                case 2:
                    displayCart();
                    break;
                case 3:
                    exitApplication();
                    break;
            }

        }

    }
// exit application method, prompts end of application
    private static void exitApplication() {
        System.out.println("Thank you for shopping with us!");
        System.exit(0);
    }
    // method displays the products and prompts the user to select choices to filter, add a product or return to homescreen
    private static void displayProducts(ArrayList<Product> products) {
        ArrayList<Product> inventory = new ArrayList<Product>();
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("What would you like to do?");
        System.out.println("1: Filter list based on Price or department ");
        System.out.println("2: Add a product to your cart");
        System.out.println("3: Go back");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                filterByCatagory();
                break;
            case 2:
                addProductToCart(products);
                break;
            case 3:
                return;
        }
    }
    private static void filterByCatagory() {
        System.out.println("which category would you like to filter by?");
        System.out.println("Enter 1 to filter by price  ");
        System.out.println("Enter 2 to filter by department.");
        System.out.println("Enter 3 to return to home ");
        int choice=input.nextInt();
        switch (choice){
            case 1:
                //filterByPrice();
            case 2:
                //filterByDepartment();
            case 3:
                returnHome();

        }
    }
/*
    private static void filterByPrice(ArrayList<Product> products) {
        System.out.println("what is the minimum price you are willing to purchase a product");
        Double min = input.nextDouble();
        System.out.println("what is the maximum price you will purchase a product for ");
        Double max = input.nextDouble();
        for (Product product : products) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                System.out.println(product);
            }

        }
    }

 */

    private static void addProductToCart(ArrayList<Product> products) {
        System.out.println("What product would you like to add to your cart?");
        String userChoice = input.nextLine();
        for (Product product: products) {
            if (product.getProductName().equalsIgnoreCase(userChoice))
                System.out.println(product);
        }

    }

    private static ArrayList<Product> getInventoryOfProducts() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        try {
            FileReader fileReader = new FileReader("products.csv");
            BufferedReader buff = new BufferedReader(fileReader);
            buff.readLine();
            String line;
            while ((line = buff.readLine()) != null) {
                String[] data = line.split("\\|");
                Product product = new Product(data[0], data[1], Double.parseDouble(data[2]), data[3]);
                inventory.add(product);

            }
        } catch (IOException e) {
            System.out.println("There was an error");
        }

        return inventory;


    }
    public static void displayCart() {
        try {
            FileReader fileReader = new FileReader("products.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

        } catch (IOException e) {
            System.out.println("Something went wrong, please try again!");
            throw new RuntimeException(e);

        }
    }

}

