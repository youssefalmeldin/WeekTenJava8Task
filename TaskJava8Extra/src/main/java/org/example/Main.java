package org.example;

import org.example.model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.model.Product.addDummyData;

public class Main {
    public static void main(String[] args) {
        List<Product> products = addDummyData();

        // Exercise 1: Obtain a list of products that belong to category "Books"
        List<Product> books = new ArrayList<>();
        products.stream()
                .filter(product -> "Books".equals(product.getCategory()))
                .forEach(books::add);
        System.out.println("Products in category 'Books': " + books);
        System.out.println("******************************************* ");


        // Exercise 2: Obtain a list of products that belong to category "Books" with price > 100
        List<Product> expensiveBooks = new ArrayList<>();
        products.stream()
                .filter(product -> "Books".equals(product.getCategory()) && product.getPrice() > 100)
                .forEach(expensiveBooks::add);
        System.out.println("Books with price > 100: " + expensiveBooks);

        System.out.println("******************************************* ");


        // Exercise 3: Obtain a list of products with category = "Toys" and apply 10% discount
        /*
        *  List<Product> discountedToys = new ArrayList<>();
        products.stream()
                .filter(product -> "Toys".equals(product.getCategory()))
                .forEach(product -> discountedToys.add(product.withPrice(product.getPrice() * 0.9)));
        System.out.println("Toys with 10% discount: " + discountedToys);
*/
        List<Product> discountedToys = products.stream()
                .filter(product -> "Toys".equals(product.getCategory()))
                .map(product -> product.withPrice(product.getPrice() * 0.9))
                .collect(Collectors.toList());
        System.out.println("Toys with 10% discount: " + discountedToys);

        System.out.println("******************************************* ");


        // Exercise 4: Get the cheapest product in the "Books" category
        Product cheapestBook = products.stream()
                .filter(product -> "Books".equals(product.getCategory()))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);
        System.out.println("Cheapest book: " + cheapestBook);
    }
}