package org.example;

public class Main {
    public static void main(String[] args) {

        WorkWithPatterns patternsDemo = new WorkWithPatterns();
        patternsDemo.demonstratePatternsOperations();

        System.out.println("\n--- Stream API Demo ---");

        WorkWithStreams streamsDemo = new WorkWithStreams();
        streamsDemo.demonstrateStreamOperations();
    }
}