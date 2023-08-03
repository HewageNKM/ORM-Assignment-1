package com.kawishika.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Book {
    @Id
    private String isbn;
    private String title;
    private String publisher;
    @ManyToMany(mappedBy = "bookList")
    private List<Author> authors;

    public Book(String b001, String madolduwaRemastard, String gg) {
        this.isbn = b001;
        this.title = madolduwaRemastard;
        this.publisher = gg;
    }
}
