package org.example;

public class Book {
    String name;
    String genre;
    String author;

    String publicationDate;
    double rating;
    double price;
    boolean loaned;

    public Book(String name, String genre, String author, String publicationDate, double rating, double price, boolean loaned) {
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.publicationDate = publicationDate;
        this.rating = rating;
        this.price = price;
        this.loaned = loaned;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", rating=" + rating +
                ", loaned=" + loaned +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public boolean isLoaned() {
        return loaned;
    }

    public void setLoaned(boolean loaned) {
        this.loaned = loaned;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
