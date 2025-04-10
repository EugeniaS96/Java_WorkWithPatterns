package org.example;

import java.util.ArrayList;
import java.util.List;

class Bookstore implements Publisher {
    private final List<Observer> observers = new ArrayList<>();
    private final List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
        notifySubscribers();
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
        notifySubscribers();
    }

    @Override
    public void notifySubscribers() {
        for (Observer observer : observers) {
            if (!books.isEmpty()) {
                observer.update(books.get(books.size() - 1));
            }
        }
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }
}
