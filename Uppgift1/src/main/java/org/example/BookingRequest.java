package org.example;

public class BookingRequest {

    private boolean goodORbad;
    private String UserID;
    private String bookName;
    private int pay;
    boolean paid;

    public BookingRequest(String UserID, String bookName, int pay, boolean paid) {
        this.UserID = UserID;
        this.bookName = bookName;
        pay = pay;
        this.paid = paid;
    }

    public BookingRequest(String bookName, boolean goodORbad) {
        this.bookName = bookName;
        this.goodORbad = goodORbad;
    }

    public boolean isGoodORbad() {
        return goodORbad;
    }

    public void setGoodORbad() {
        this.goodORbad = goodORbad;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
