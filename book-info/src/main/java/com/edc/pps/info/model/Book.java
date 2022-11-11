package com.edc.pps.info.model;


// TODO: comparable is generic, use <>
public class Book implements Comparable {


    private static long countId = 0L;

    {
        countId++;
    }

    private long bookId;

    // TODO: rename to title
    // it's clear you are in the book class: book.title vs book.bookTitle
    private String bookTitle;
    private String bookAuthor;

    // TODO: should be integer 1-5
    private double bookRating;

    public Book(String bookTitle, String bookAuthor) {
        this.bookId = countId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public double getBookRating() {
        return bookRating;
    }

    public void setBookRating(double bookRating) {
        this.bookRating = bookRating;
    }

    @Override
    public String toString() {
        return bookRating != 0.0 ? "bookinfo.Book details:\n" +
                "ID: " + bookId + "\n" +
                "Title: '" + bookTitle + "\'\n" +
                "Author: " + bookAuthor + "\n" +
                "bookinfo.Rating: " + bookRating + "\n" :
                "bookinfo.Book details:\n" +
                        "ID: " + bookId + "\n" +
                        "Title: '" + bookTitle + "\'\n" +
                        "Author: " + bookAuthor + "\n" +
                        "Nu are rating" + "\n";
    }


    @Override
    public int compareTo(Object o) {
        Book otherBook = (Book) o;
        return (int) (this.bookId - otherBook.getBookId());
    }
}

