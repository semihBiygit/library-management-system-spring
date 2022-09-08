package com.semih.librarymanagementsystem.repository;

import com.semih.librarymanagementsystem.repository.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {

    List<Book> findBookByBorrowedIsFalse();
}
