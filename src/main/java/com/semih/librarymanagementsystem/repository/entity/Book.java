package com.semih.librarymanagementsystem.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Book extends StateInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "book_type")
    @Enumerated(EnumType.STRING)
    private BookType bookType;

    @Column(name = "is_borrowed")
    private boolean borrowed;
    @OneToMany
    private List<BorrowBook> borrowBookList;


}
