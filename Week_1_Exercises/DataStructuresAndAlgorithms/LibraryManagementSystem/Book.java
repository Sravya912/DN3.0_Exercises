package lms;

import java.util.Arrays;

public class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }

    public static class LibraryManagementSystem {
        public static Book linearSearch(Book[] books, String title) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    return book;
                }
            }
            return null;
        }

        public static Book binarySearch(Book[] books, String title) {
            int left = 0;
            int right = books.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int cmp = books[mid].getTitle().compareToIgnoreCase(title);
                if (cmp == 0) {
                    return books[mid];
                } else if (cmp < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return null;
        }

        public static void main(String[] args) {
            Book[] books = {
                new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"),
                new Book("B002", "1984", "George Orwell"),
                new Book("B003", "To Kill a Mockingbird", "Harper Lee")
            };

            System.out.println("Linear Search:");
            Book result = linearSearch(books, "1984");
            System.out.println(result != null ? result : "Book not found");

            Arrays.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

            System.out.println("\nBinary Search:");
            result = binarySearch(books, "To Kill a Mockingbird");
            System.out.println(result != null ? result : "Book not found");
        }
    }
}
