package com.alfidotech.service;

import java.util.List;

import com.alfidotech.entity.Student; 


public interface StuService {

	public Student saveStu(Student stu);

	public List<Student> getAllStu();

	public Student getStuById(int id);

	public boolean deleteStu(int id);

}
