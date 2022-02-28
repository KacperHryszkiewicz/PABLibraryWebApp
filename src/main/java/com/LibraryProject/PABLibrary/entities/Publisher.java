package com.LibraryProject.PABLibrary.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Publishers")
@Data
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher", orphanRemoval = true)
    private List<Book> bookList = new ArrayList<>();

    public Publisher(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Publisher() {
    }
}
