package com.semih.librarymanagementsystem.service;

import com.semih.librarymanagementsystem.repository.IBookRepository;
import com.semih.librarymanagementsystem.repository.IBorrowBookRepository;
import com.semih.librarymanagementsystem.repository.IStudentRepository;
import com.semih.librarymanagementsystem.repository.entity.Book;
import com.semih.librarymanagementsystem.repository.entity.BorrowBook;
import com.semih.librarymanagementsystem.repository.entity.Student;
import org.springframework.stereotype.Service;


@Service
public class BorrowBookService extends ServiceManager<BorrowBook, Long> {
    private final IBorrowBookRepository borrowBookRepository;
    private final IBookRepository bookRepository;
    private final IStudentRepository studentRepository;

    public BorrowBookService(IBorrowBookRepository borrowBookRepository, IBookRepository bookRepository, IStudentRepository studentRepository) {
        super(borrowBookRepository);
        this.borrowBookRepository = borrowBookRepository;
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
    }

    public BorrowBook borrowBook(Long bookId, Long studentId) {
        BorrowBook borrowBook;
        Book book = bookRepository.getReferenceById(bookId);
        Student student = studentRepository.getReferenceById(studentId);
        if (book != null && !book.isBorrowed() && student != null) {
            book.setBorrowed(true);
            borrowBook = new BorrowBook();
            borrowBook.setBook(book);
            borrowBook.setStudent(student);
            borrowBook.setBookBorrowDate(System.currentTimeMillis());
            borrowBookRepository.save(borrowBook);
        } else {
            throw new RuntimeException("Book is borrowed or student is not found");
        }
        return borrowBook;
    }

}

