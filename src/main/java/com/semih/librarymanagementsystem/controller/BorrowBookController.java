package com.semih.librarymanagementsystem.controller;

import com.semih.librarymanagementsystem.repository.entity.BorrowBook;
import com.semih.librarymanagementsystem.service.BorrowBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrow")
@RequiredArgsConstructor
public class BorrowBookController {
    private final BorrowBookService borrowBookService;

    @PostMapping("/borrowbook")
    public ResponseEntity<BorrowBook> borrowBook(Long bookId, Long studentId) {
        return ResponseEntity.ok(borrowBookService.borrowBook(bookId, studentId));
    }
}
