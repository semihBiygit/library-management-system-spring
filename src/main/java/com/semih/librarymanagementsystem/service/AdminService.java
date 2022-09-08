package com.semih.librarymanagementsystem.service;

import com.semih.librarymanagementsystem.repository.IAdminRepository;
import com.semih.librarymanagementsystem.repository.entity.Admin;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends ServiceManager<Admin, Long> {

    private final IAdminRepository adminRepository;

    public AdminService(IAdminRepository adminRepository) {
        super(adminRepository);
        this.adminRepository = adminRepository;
    }
}
