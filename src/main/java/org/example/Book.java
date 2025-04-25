package org.example;
import java.util.Objects;

public class Book {
    private final String title;
    private final int year;
    private final int pages;
    private final int chapters;
    private final String annotation;

    private Book(Builder builder) {
        this.title = builder.title;
        this.year = builder.year;
        this.pages = builder.pages;
        this.chapters = builder.chapters;
        this.annotation = builder.annotation;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public int getChapters() {
        return chapters;
    }

    public String getAnnotation() {
        return annotation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && pages == book.pages && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, pages);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                ", chapters=" + chapters +
                ", annotation='" + annotation + '\'' +
                '}';
    }
    public static class Builder {
        private String title;
        private int year;
        private int pages;
        private int chapters = 0;
        private String annotation = "";

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Builder setPages(int pages) {
            this.pages = pages;
            return this;
        }

        public Builder setChapters(int chapters) {
            this.chapters = chapters;
            return this;
        }

        public Builder setAnnotation(String annotation) {
            this.annotation = annotation;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}

