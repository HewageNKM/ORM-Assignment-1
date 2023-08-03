package com.kawishika;

import com.kawishika.entity.Author;
import com.kawishika.entity.Book;
import com.kawishika.util.SessionConfigure;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Session session = SessionConfigure.getInstance().getSession();
        Author author1 = new Author("A001", "Kawdasfika", "adfd@.com");
        Author author2 = new Author("A002", "Kawjuika", "adfd@.com");

        ArrayList<Author> authorArrayList = new ArrayList<>();
        authorArrayList.add(author1);
        authorArrayList.add(author2);
        Book book1 = new Book("B001", "MadolDsa", "GG");
        Book book2 = new Book("B002", "FADFs", "GG");
        ArrayList<Book> bookArrayList1 = new ArrayList<>();
        bookArrayList1.add(book1);
        bookArrayList1.add(book2);

        Book book3 = new Book("B003", "FADFs", "GG");
        book3.setAuthors(authorArrayList);
        Book book4 = new Book("B004", "FADFs", "GG");
        book4.setAuthors(authorArrayList);
        ArrayList<Book> bookArrayList2 = new ArrayList<>();
        bookArrayList2.add(book3);
        bookArrayList2.add(book4);

        author1.setBookList(bookArrayList1);
        author1.setBookList(bookArrayList2);
        author2.setBookList(bookArrayList1);
        author2.setBookList(bookArrayList2);

        ArrayList<Book> bookArrayList3 = new ArrayList<>();
        bookArrayList3.add(book1);
        bookArrayList3.add(book2);
        bookArrayList3.add(book3);
        bookArrayList3.add(book4);

        author1.setBookList(bookArrayList3);
        author2.setBookList(bookArrayList3);

        book1.setAuthors(authorArrayList);
        book2.setAuthors(authorArrayList);
        book3.setAuthors(authorArrayList);
        book4.setAuthors(authorArrayList);

        Transaction transaction = session.beginTransaction();
        session.persist(author1);
        session.persist(author2);
        session.persist(book1);
        session.persist(book2);
        session.persist(book3);
        session.persist(book4);
        transaction.commit();
    }
}