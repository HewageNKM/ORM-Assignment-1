package com.kawishika;

import com.kawishika.entity.Author;
import com.kawishika.entity.Book;
import com.kawishika.util.SessionConfigure;
import org.hibernate.Session;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Session session = SessionConfigure.getInstance().getSession();
        Author author = new Author("A001", "Kawishika", "FEadf@gmamf.com");
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book("B001", "Madolduwa Remastard", "GG",author);
        Book book2 = new Book("B002", "Madolduwa Remastard", "GG",author);
        books.add(book1);
        books.add(book2);

        author.setBookList(books);

        session.beginTransaction();
        session.persist(book1);
        session.persist(book2);

        session.persist(author);
        session.getTransaction().commit();
    }
}