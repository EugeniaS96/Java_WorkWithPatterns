package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WorkWithStreams {
    public void demonstrateStreamOperations() {

        Book book1 = new Book.Builder().setTitle("War and Peace").setYear(1869).setPages(2144).build();
        Book book2 = new Book.Builder().setTitle("Harry Potter 1").setYear(1997).setPages(223).build();
        Book book3 = new Book.Builder().setTitle("For Whom the Bells Tolls").setYear(1940).setPages(480).build();
        Book book4 = new Book.Builder().setTitle("Pride and Prejudice").setYear(1813).setPages(320).build();
        Book book5 = new Book.Builder().setTitle("Fahrenheit").setYear(1953).setPages(288).build();
        Book book6 = new Book.Builder().setTitle("The Hunger Games").setYear(2008).setPages(384).build();
        Book book7 = new Book.Builder().setTitle("The Tenant of Wildfell Hall").setYear(1848).setPages(480).build();
        Book book8 = new Book.Builder().setTitle("Shantaram").setYear(2003).setPages(1016).build();
        Book book9 = new Book.Builder().setTitle("The Clash of Civilizations").setYear(1993).setPages(640).build();
        Book book10 = new Book.Builder().setTitle("Jane Eyre").setYear(1847).setPages(672).build();
        Book book11 = new Book.Builder().setTitle("A song of Ice and Fire").setYear(1996).setPages(768).build();
        Book book12 = new Book.Builder().setTitle("Mio, my Son").setYear(1954).setPages(128).build();
        Book book13 = new Book.Builder().setTitle("The Captain's Daughter").setYear(1836).setPages(183).build();
        Book book14 = new Book.Builder().setTitle("A Hero of our time").setYear(1839).setPages(170).build();
        Book book15 = new Book.Builder().setTitle("Gone with the wind").setYear(1939).setPages(704).build();

        Student student1 = new Student("Maria", new ArrayList<>(Arrays.asList(book1, book2, book3, book4, book5)));
        Student student2 = new Student("Vasya", new ArrayList<>(Arrays.asList(book6, book7, book8, book9, book10)));
        Student student3 = new Student("Ivan", new ArrayList<>(Arrays.asList(book11, book12, book13, book14, book15)));

        List<Student> students = List.of(student1, student2, student3);

        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .peek(Book::getYear)
                .findAny()
                .ifPresentOrElse(
                        book -> System.out.println("Publication year of the book found: " + book.getYear()),
                        () -> System.out.println("Book not found")
                );
    }
}