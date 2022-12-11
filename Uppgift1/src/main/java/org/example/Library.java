package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Library() {
        books = new ArrayList<>();
        books.add(new Book("Book1", "kid's", "Stephen Smith", "1950", 8, 59, false));
        books.add(new Book("Book2", "comedy", "Cleveland Brown", "2003",9 , 69, false));
        books.add(new Book("Book3", "sci-fi", "Steve Johnson ", "2010", 3, 79, true));
        books.add(new Book("Book4", "action", "Martin Davis", "2001", 7, 49,false));
        books.add(new Book("Book5", "drama", "Zlatan Ibrahimović", "2004", 5,99,false));
        books.add(new Book("Book6", "fantasy", "Esteban Garcia", "1999", 6, 39,false));
        books.add(new Book("Book7", "romance", "Juan Suarez", "1990", 7, 29,false));
    }
}
