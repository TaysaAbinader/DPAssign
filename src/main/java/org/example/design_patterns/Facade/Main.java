package org.example.design_patterns.Facade;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Create an instance of our Facade
        ApiFacade facade = new ApiFacade();

        // --- TEST 1: Chuck Norris API ---
        System.out.println("--- Chuck Norris Joke ---");
        try {
            String joke = facade.getAttributeValueFromJson(
                "https://api.chucknorris.io/jokes/random",
                "value"
            );
            System.out.println("Result: " + joke);
        } catch (IOException e) {
            System.err.println("Connection error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("JSON error: " + e.getMessage());
        }

        System.out.println("\n---------------------------\n");

        // --- TEST 2: FX Rates API ---
        System.out.println("--- Latest FX Base Currency ---");
        try {
            String baseCurrency = facade.getAttributeValueFromJson(
                "https://api.fxratesapi.com/latest",
                "base"
            );
            System.out.println("Result: " + baseCurrency);
        } catch (IOException e) {
            System.err.println("Connection error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("JSON error: " + e.getMessage());
        }

        System.out.println("\n---------------------------\n");

        // --- TEST 3: Demonstrating Error Handling (Invalid Attribute) ---
        System.out.println("--- Testing Error Handling (Missing Attribute) ---");
        try {
            // "non_existent_key" does not exist in the Chuck Norris JSON
            facade.getAttributeValueFromJson(
                "https://api.chucknorris.io/jokes/random",
                "non_existent_key"
            );
        } catch (IOException e) {
            System.err.println("Connection error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Error: " + e.getMessage());
        }
    }
}
