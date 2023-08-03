package com.kawishika.entity;

import jakarta.persistence.*;
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
    @ManyToOne
    private Author author;
}
