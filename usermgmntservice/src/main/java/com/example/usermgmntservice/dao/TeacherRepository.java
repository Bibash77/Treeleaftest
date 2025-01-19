package com.example.usermgmntservice.dao;

import com.example.usermgmntservice.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {}
