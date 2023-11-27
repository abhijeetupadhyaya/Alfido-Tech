package com.aalfidotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aalfidotech.entity.Student;

public interface StuRepository extends JpaRepository<Student, Integer> {

}
