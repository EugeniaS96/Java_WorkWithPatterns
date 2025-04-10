package org.example;

class Customer implements Observer {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Book book) {
        System.out.println(name + ", new book is available now: " + book.getTitle() + " (" + book.getYear() + ")");
    }
}