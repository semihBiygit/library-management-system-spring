package com.semih.librarymanagementsystem.service;

import com.semih.librarymanagementsystem.repository.IStudentRepository;
import com.semih.librarymanagementsystem.repository.entity.BorrowBook;
import com.semih.librarymanagementsystem.repository.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends ServiceManager<Student, Long> {

    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        super(studentRepository);
        this.studentRepository = studentRepository;
    }

}

