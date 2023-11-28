package com.alfidotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alfidotech.entity.Student;

public interface StuRepository extends JpaRepository<Student, Integer> {

}
