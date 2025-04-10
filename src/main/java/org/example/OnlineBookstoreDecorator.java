package org.example;

// Декоратор для онлайн-продаж
class OnlineBookstoreDecorator implements Publisher {
    private final Bookstore bookStore;

    public OnlineBookstoreDecorator(Bookstore bookStore) {
        this.bookStore = bookStore;
    }
    @Override
    public void addBook(Book book) {
        bookStore.addBook(book);
    }
    @Override
    public void removeBook(Book book) {
        bookStore.removeBook(book);
    }
    @Override
    public void notifySubscribers() {
        bookStore.notifySubscribers();
    }
    @Override
    public void subscribe(Observer observer) {
        bookStore.subscribe(observer);
    }
    @Override
    public void unsubscribe(Observer observer) {
        bookStore.unsubscribe(observer);
    }

    public void sellOnline(Book book) {
        System.out.println("You bought this book online " + book.getTitle());
    }
}
