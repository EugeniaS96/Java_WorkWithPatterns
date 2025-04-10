package org.example;

class HomeDeliveryBookstoreDecorator implements Publisher {
    private final Bookstore bookStore;

    public HomeDeliveryBookstoreDecorator(Bookstore bookStore) {
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

    public void deliverHome(Book book) {
        System.out.println("Book has been delivered to your home: " + book.getTitle());
    }
}
