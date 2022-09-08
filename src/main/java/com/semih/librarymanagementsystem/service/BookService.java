package com.semih.librarymanagementsystem.service;

import com.semih.librarymanagementsystem.repository.IBookRepository;
import com.semih.librarymanagementsystem.repository.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends ServiceManager<Book, Long> {

    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        super(bookRepository);
        this.bookRepository = bookRepository;
    }

    public List<Book> findBookByBorrowedIsFalse() {
        return bookRepository.findBookByBorrowedIsFalse();
    }
}

