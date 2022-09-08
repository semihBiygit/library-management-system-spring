package com.semih.librarymanagementsystem.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BorrowBook extends StateInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "book_borrow_date")
    private long bookBorrowDate;
    @Column(name = "rental_length")
    private int rentalLength;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
    @ManyToOne

    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
}
