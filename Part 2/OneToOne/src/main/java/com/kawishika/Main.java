package com.kawishika;

import com.kawishika.entity.Author;
import com.kawishika.entity.Book;
import com.kawishika.util.SessionConfigure;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = SessionConfigure.getInstance().getSession();
        session.beginTransaction();
        Author author = new Author("A001", "Kawishika", "fd@gmail.com");
        session.persist(author);
        session.persist(new Book("B001", "Madolduwa Remastard", "GG",author));
        session.getTransaction().commit();
    }
}