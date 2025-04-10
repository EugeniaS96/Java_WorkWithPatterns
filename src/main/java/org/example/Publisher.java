package org.example;

public interface Publisher {
    void addBook(Book book);
    void removeBook(Book book);
    void notifySubscribers();
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    }
