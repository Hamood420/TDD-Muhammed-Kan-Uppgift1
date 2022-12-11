package org.example;

import java.util.ArrayList;

public class BookingService {

    private Library library;
    private PaymentService paymentService;

    public BookingService(PaymentService paymentService) {
        this.paymentService = paymentService;
        library = new Library();
    }

    public boolean loanBook(BookingRequest bookingRequest) {
        for (var item : library.getBooks()) {
            if ((item.getName().equalsIgnoreCase(bookingRequest.getBookName()) && item.isLoaned()) == true) {
                if (bookingRequest.isGoodORbad() == true) {
                    item.setRating(item.rating +1);
                    System.out.println(item.getRating());
                }

                item.setLoaned(false);
                System.out.println("The book is returned: " + item.getName());

                return true;
            }
        }

        return false;
    }

    public ArrayList<String> searchByRate(int rating) {
        ArrayList<String> availableBooks = new ArrayList<>();
        for (var item: library.getBooks()) {
            if (item.isLoaned() == false) {
                System.out.println(item.getName());
                availableBooks.add(item.getName());
            }
        }

        return availableBooks;
    }

    public ArrayList<String> searchBook(String userSearch) {
        ArrayList<String> availableBooks = new ArrayList<>();
        for (var item: library.getBooks()) {
            if (item.getName().equalsIgnoreCase(userSearch) || item.getAuthor().equalsIgnoreCase(userSearch) || item.getGenre().equalsIgnoreCase(userSearch) || item.getPublicationDate().equalsIgnoreCase(userSearch)) {
                System.out.println(item.getName());
                availableBooks.add(item.getName());
            }
        }

        return availableBooks;
    }

    public boolean returnBook(BookingRequest bookingRequest) {
        for (var item : library.getBooks()) {

            if (item.getName().equalsIgnoreCase(bookingRequest.getBookName()) && item.isLoaned() == true) {

                if (bookingRequest.isGoodORbad() == true) {
                    item.setRating(item.getRating() + 1);
                    System.out.println(item.getRating());
                }

                item.setLoaned(false);
                System.out.println("Book returned: " + item.getName());

                return true;
            }
        }
        return false;
    }
}
