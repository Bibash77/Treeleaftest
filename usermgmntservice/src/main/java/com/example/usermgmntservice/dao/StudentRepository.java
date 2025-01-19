package com.example.usermgmntservice.dao;

import com.example.usermgmntservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}
