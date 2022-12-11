package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookService {

    static Library library = new Library();
    static Scanner in = new Scanner(System.in);

    public BookService() {
    }

    public static void main(String[] args) {
      System.out.println("\n Please enter 0 to view our list of books. " +
              "\n Please enter 1 to search book name you request" +
              "\n Please enter 2 to search book genre you request" +
              "\n Please enter 3 to search book author you request" +
              "\n Please enter 4 to search book ratings you request" +
              "\n Please enter 5 to select the book you request" +
              "\n Please enter 6 to search publication Date for your request"
              );
    int answer = in.nextInt();
        switch (answer) {
        case 0:
            showBookList();
            System.out.println("------------------");
            main(args);

            int again = in.nextInt();
            break;

        case 1:
            System.out.println("\n Please enter book name");
            String name = in.next();
            filterByName(name).stream().forEach(System.out::println);
            System.out.println("------------------");
            main(args);

            int again2 = in.nextInt();
            break;

        case 2:
            System.out.println("\n Please enter author name");
            String author = in.next();
            filterByAuthor(author).stream().forEach(System.out::println);
            System.out.println("------------------");
            main(args);

            int again3 = in.nextInt();
            break;

        case 3:
            System.out.println("\n Please enter genre of the book");
            String genre = in.next();
            filterByGenre(genre).stream().forEach(System.out::println);
            System.out.println("------------------");
            main(args);

            int again4 = in.nextInt();
            break;

        case 4:
            System.out.println("\n Please enter the name of the book you want to loan");
            String book = in.next();
            try {
                loan(book);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            break;

        case 5:
            System.out.println("\n Please enter the publication date for the book");
            String date = in.next();
            filterByPublicationDate(date).stream().forEach(System.out::println);
            System.out.println("------------------");
            main(args);

            int again5 = in.nextInt();
            break;

        case 6:
            filterByRating();
            System.out.println("------------------");
            main(args);

            int again6 = in.nextInt();
            break;
    }
}

    public static void showBookList() {
        library.getBooks().stream().forEach(System.out::println);
    }

    public static List<Book> filterByName(String name) {
        List<Book> books = library.getBooks().stream().filter(book -> book.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        return books;
    }

    public static List<Book> filterByGenre(String genre) {
        List<Book> books = library.getBooks().stream().filter(book -> book.getGenre().equals(genre)).collect(Collectors.toList());
        return books;
    }

    public static List<Book> filterByAuthor(String author) {
        List<Book> books = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
        return books;

    }

    public static void filterByRating() {
        List<Book> books = library.getBooks().stream().sorted(Comparator.comparingDouble(Book::getRating).reversed()).collect(Collectors.toList());
        books.stream().forEach(System.out::println);

    }

    public static List<Book> filterByPublicationDate(String date) {
        List<Book> books = library.getBooks().stream().filter(B -> B.getPublicationDate().equals(date)).collect(Collectors.toList());
        return books;
    }

    public static void loan(String book) throws Exception{
        List<Book> books = library.getBooks();

        for (Book B : books) {
            if (B.isLoaned()) {
                throw new Exception("The book you request is already loaned. Please choose a different one");
            }
            else{
                System.out.println("The price for this book is: " + B.getPrice());
                System.out.println("Do you want to loan this book (yes/no)");
                String answer = in.next();
                if (answer.equalsIgnoreCase("yes")){
                    B.setLoaned(true);
                    System.out.println("The book is loand");
                }
                else{
                    System.out.println("The book you've chosen is not loaned");
                }
            }
        }
    }

}
