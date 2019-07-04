package com.homework.maxcxam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Payment {
    private Map<Integer, Product> shoppingCart = new HashMap<>();
    private Map<Integer, Product> shop = new HashMap<>();
    private int cartItemId = 1;

    public class Product {
        private double price;
        private String name;

        Product(String name, double price) {
            this.price = price;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        private double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return String.format("%s price: $%s", name, price);
        }
    }

    private Payment(){
        shop.put(1, new Product("Milk", 27.5));
        shop.put(2, new Product("Water", 17.25));
        shop.put(3, new Product("Cola", 15.7));
        shop.put(4, new Product("Tea", 13));
        shop.put(5, new Product("Coffee", 61));
        startShopping();
    }

    private void startShopping(){
        Scanner in = new Scanner(System.in);
        System.out.println("Wellcome to Maksym shop!!! my products below:");
        String shopping = "y";
        while (shopping.equalsIgnoreCase("y")) {
            for (int i = 1; i<= shop.size(); i++){
                System.out.printf("%s - %s%n", i, shop.get(i));
            }
            System.out.println("Your choose ?");
            int productId = in.nextInt();
            if(productId > 0 && productId <= shop.size()) {
                shoppingCart.put(cartItemId, shop.get(productId));
                cartItemId++;
                System.out.println("something else? (Y/n):");
                shopping = in.next();
            } else {
                System.out.println("we havent product with this id:" + productId);
                System.out.println("May be something else? Y/n):");
                shopping = in.next();
            }
        }

        calculateShoppingCart();

    }

    private void calculateShoppingCart() {
        System.out.println("In your cart:");
        double total = 0;
        for (int i = 1; i<= shoppingCart.size(); i++) {
            System.out.printf("%s%n", shoppingCart.get(i));
            total += shoppingCart.get(i).getPrice();
        }
        System.out.printf("Total price is $%s", total);
    }

    public static void main(String[] args) {
        new Payment();
    }
}
