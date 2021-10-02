package com.solid.book;

import java.util.List;

public class BookReader implements Reader {
    public void printToScreen(Book book) {
        // Book book = this;
        do {
            System.out.println(book.getCurrentPage());
        } while (book.turnToNextPage());
    }

    public static void main(String[] args) {
        Book book = new Book("Tyland", List.of("I", "moved", "here", "recently", "too"));
        BookReader reader = new BookReader();
        reader.printToScreen(book);

        // reader.printTofile(book);
    }

}
