package com.example.usermgmntservice.dao;

import org.example.usermanagementservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}
