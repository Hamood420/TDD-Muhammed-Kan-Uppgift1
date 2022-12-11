package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MainTest {

    private PaymentService paymentService;
    private BookingService bookingService;
    private BookService bookService;
    private ArgumentCaptor<Integer> payArgumentCaptor;

    @BeforeEach
    void setUpTheLibrary() {
        paymentService = mock(PaymentService.class);
        bookingService = new BookingService(paymentService);
        bookService = new BookService();
        payArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
    }

    @Test
    public void If_The_Book_Is_Unloaned_It_Should_Get_Loaned() {
        BookingRequest bookingRequestLoan = new BookingRequest("1", "Book1", 59 , true);
        boolean requestLoanBook2 = bookingService.loanBook(bookingRequestLoan);

        assertEquals(true, requestLoanBook2);
    }

    @Test
    public void Loaned_Books_Should_Be_True_When_Returned() {
        BookingRequest bookingRequestLoan = new BookingRequest("1", "Book2", 59 , true);
        BookingRequest bookingRequestReturn = new BookingRequest("Book2", true);
        bookingService.loanBook(bookingRequestLoan);
        boolean requestReturnOnBook2 = bookingService.returnBook(bookingRequestReturn);

        assertEquals(true, requestReturnOnBook2);
    }

    @Test
    public void Loaned_Books_Should_Not_Work_When_Tried_To_Loan() {
        BookingRequest bookingRequestLoan1 = new BookingRequest("1", "Book1", 59 , true);
        BookingRequest bookingRequestLoan2 = new BookingRequest("1", "Book2", 59 , true);

        bookingService.loanBook(bookingRequestLoan1);

        boolean requestLoanOnBook2 = bookingService.loanBook(bookingRequestLoan2);

        assertNotEquals(true, bookingRequestLoan2);
    }

    @Test
    public void Books_Should_Be_Loaned_When_Right_Amount_Of_Money_Is_Paid() {
        BookingRequest bookingRequestLoan1 = new BookingRequest("1", "Book1", 59 , true);
        bookingService.loanBook(bookingRequestLoan1);

        verify(paymentService, times(1)).pay(payArgumentCaptor.capture());
        int amountToPay = payArgumentCaptor.getValue();

        assertEquals(59, amountToPay);
    }

    @Test
    public void Search_Book_By_Author() {
        ArrayList<String> expected = bookingService.searchBook("Stephen Smith");
        ArrayList<String> actual = new ArrayList<>();
        actual.add("Book1");

        assertEquals(expected, actual);
    }

    @Test
    public void Search_Book_By_Genre() {
        ArrayList<String> expected = bookingService.searchBook("kid's");
        ArrayList<String> actual = new ArrayList<>();
        actual.add("Book1");
        actual.add("Book2");

        assertEquals(expected, actual);
    }

    @Test
    public void Search_Book_By_Name() {
        ArrayList<String> expected = bookingService.searchBook("Book1");
        ArrayList<String> actual = new ArrayList<>();
        actual.add("Book1");

        assertEquals(expected, actual);
    }

    @Test
    public void Search_Book_By_Its_Rate() {
        BookingRequest bookingRequestLoan1 = new BookingRequest("1", "Book1", 59 , true);
        BookingRequest bookingRequestReturn1 = new BookingRequest("Book1", true);
        BookingRequest bookingRequestLoan2 = new BookingRequest("1", "Book2", 59 , true);
        BookingRequest bookingRequestReturn2 = new BookingRequest("Book2", true);

        bookingService.loanBook(bookingRequestLoan1);
        bookingService.loanBook(bookingRequestLoan2);
        bookingService.returnBook(bookingRequestReturn1);
        bookingService.returnBook(bookingRequestReturn2);

        bookingService.loanBook(bookingRequestLoan1);
        bookingService.loanBook(bookingRequestLoan2);
        bookingService.returnBook(bookingRequestReturn1);
        bookingService.returnBook(bookingRequestReturn2);

        ArrayList<String> acutalList = bookingService.searchByRate(2);
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Book1");
        expectedList.add("Book2");

        System.out.println("(actual) Available books: " + acutalList.get(0) + "\n" + acutalList.get(1));
        System.out.println("(expected) Available  books: " + expectedList.get(0) + "\n" + expectedList.get(1));

        assertEquals(expectedList, acutalList);
    }
}