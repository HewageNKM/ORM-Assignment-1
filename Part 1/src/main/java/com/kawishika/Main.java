package com.kawishika;

import com.kawishika.entity.Book;
import com.kawishika.util.SessionConfigure;
import lombok.SneakyThrows;
import org.hibernate.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Session session = SessionConfigure.getInstance().getSession();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            loadMenu();
            int choice = getChoice(reader);
            switch (choice) {
                case 1:
                    addBook(session, reader);
                    break;
                case 2:
                    updateBook(session, reader);
                    break;
                case 3:
                    deleteBook(session, reader);
                    break;
                case 4:
                    session.close();
                    System.exit(0);
            }
        }
    }

    private static void deleteBook(Session session, BufferedReader reader) throws IOException {
        System.out.print("Enter ISBN : ");
        String ISBM =  reader.readLine();
        if(session.get(Book.class,ISBM) != null){
            session.beginTransaction();
            session.delete(session.get(Book.class,ISBM));
            session.getTransaction().commit();
        }else {
            System.out.println("Book does not exist");
        }
    }


    private static void updateBook(Session session, BufferedReader reader) throws IOException {
        String ISBN;
        String title;
        String publisher;
        System.out.print("\n Enter ISBN : ");
        ISBN = reader.readLine();
        if (session.get(Book.class, ISBN) != null) {
            System.out.print("\n Enter title : ");
            title = reader.readLine();
            System.out.print("\n Enter publisher : ");
            publisher = reader.readLine();
            session.beginTransaction();
            Book book = session.get(Book.class, ISBN);
            book.setTitle(title);
            book.setPublisher(publisher);
            session.getTransaction().commit();
        } else {
            System.out.println("Book does not exist, Use option 1 to add a book");
        }
    }

    private static void addBook(Session session, BufferedReader reader) throws IOException {
        String ISBN;
        String title;
        String publisher;
        System.out.print("\n Enter ISBN : ");
        ISBN = reader.readLine();
        if (session.get(Book.class, ISBN) != null) {
            System.out.println("Book already exists");
        } else {
            System.out.print("\n Enter title : ");
            title = reader.readLine();
            System.out.print("\n Enter publisher : ");
            publisher = reader.readLine();
            session.beginTransaction();
            session.persist(new Book(ISBN, title, publisher));
            session.getTransaction().commit();
        }
    }

    private static int getChoice(BufferedReader reader) throws IOException {
        while (true) {
            System.out.print("\n Enter : ");
            int choice;
            try {
                choice = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
                continue;
            }
            if (choice >= 1 && choice <= 4) {
                return choice;
            } else {
                System.out.println("Invalid choice");
                loadMenu();
            }
        }
    }

    private static void loadMenu() {
        System.out.printf("%70s", "Welcome to the Book Management System\n");
        System.out.printf("%20s", "1. Add a book");
        System.out.printf("%20s", "2. Update a book");
        System.out.printf("%20s", "3. Delete a book");
        System.out.printf("%15s", "4. Exit");
        System.out.println();
    }
}