package com.kawishika.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@AllArgsConstructor
@Data
public class Author {
    @Id
    private String authorId;
    private String name;
    private String email;
    @ManyToMany
    private List<Book> bookList;

    public Author(String a001, String kawishika, String mail) {
        this.authorId = a001;
        this.name = kawishika;
        this.email = mail;
    }
}
