package com.kawishika.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class Author {
    @Id
    private String authorId;
    private String name;
    private String email;
}
