package com.aalfidotech.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.aalfidotech.entity.Student;
import com.aalfidotech.repository.StuRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class StuServiceImpl implements StuService {

	@Autowired
	private StuRepository stuRepo;

	@Override
	public Student saveStu(Student stu) {
		Student newStu = stuRepo.save(stu);
		return newStu;
	}

	@Override
	public List<Student> getAllStu() {

		return stuRepo.findAll();
	}

	@Override
	public Student getStuById(int id) {
		return stuRepo.findById(id).get();
	}

	@Override
	public boolean deleteStu(int id) {
		Student stu = stuRepo.findById(id).get();
		if (stu != null) {
			stuRepo.delete(stu);
			return true;
		}
		return false;
	}

	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");

	}

}
