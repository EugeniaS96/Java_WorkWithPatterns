package org.example;

public class WorkWithPatterns {
    public void demonstratePatternsOperations() {

        ConfigurationProxy userProxy = new ConfigurationProxy(false);
        ConfigurationProxy adminProxy = new ConfigurationProxy(true);

        try {
            System.out.println("Configuration for user: " + userProxy.getConfig());
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

        try {
            userProxy.setConfig("New Configuration");
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

        try {
            adminProxy.setConfig("New Configuration");
            System.out.println("Configuration has been changed by admin: " + adminProxy.getConfig());
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("--------------");

        Customer customer1 = new Customer("Maria");
        Customer customer2 = new Customer("Vasya");

        Bookstore bookStore = new Bookstore();

        bookStore.subscribe(customer1);
        bookStore.subscribe(customer2);

        OnlineBookstoreDecorator onlineBookStore = new OnlineBookstoreDecorator(bookStore);
        HomeDeliveryBookstoreDecorator homeDeliveryBookStore = new HomeDeliveryBookstoreDecorator(bookStore);

        Book book1 = new Book.Builder()
                .setTitle("War and Peace")
                .setYear(1869)
                .setPages(2144)
                .setChapters(94)
                .setAnnotation("History novel about the war of 1812")
                .build();

        bookStore.addBook(book1);

        onlineBookStore.sellOnline(book1);
        homeDeliveryBookStore.deliverHome(book1);

        Book book2 = new Book.Builder()
                .setTitle("Harry Potter 1")
                .setYear(1997)
                .setPages(223)
                .build();
        System.out.println(book2);
        bookStore.addBook(book2);
    }
}