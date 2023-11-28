package com.alfidotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alfidotech.entity.Student;
import com.alfidotech.service.StuService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

	@Autowired
	private StuService stuService;

	
	@GetMapping("/")
	public String index(Model m) {
		List<Student> list = stuService.getAllStu();
		m.addAttribute("stuList", list);
		return "index";
	}

	@GetMapping("/loadStuSave")
	public String loadStuSave() {
		return "stu_save";
	}

	@GetMapping("/EditStu/{id}")
	public String EditStu(@PathVariable int id, Model m) {
		// System.out.println(id);
		Student stu = stuService.getStuById(id);
		m.addAttribute("stu", stu);
		return "edit_stu";
	}

	@PostMapping("/saveStu")
	public String saveStu(@ModelAttribute Student stu, HttpSession session) {
		// System.out.println(stu);

		Student newStu = stuService.saveStu(stu);

		if (newStu != null) {
			// System.out.println("save success");
			session.setAttribute("msg", "Student added successfully");
		} else {
			// System.out.println("something wrong on server");
			session.setAttribute("msg", "something went wrong on server");
		}

		return "redirect:/loadStuSave";
	}

	@PostMapping("/updateStuDtls")
	public String updateStu(@ModelAttribute Student stu, HttpSession session) {
		// System.out.println(stu);

		Student updateStu = stuService.saveStu(stu);

		if (updateStu != null) {
			// System.out.println("save success");
			session.setAttribute("msg", "Student details updated sucessfully");
		} else {
			// System.out.println("something wrong on server");
			session.setAttribute("msg", "something went wrong on server");
		}

		return "redirect:/";
	}

	@GetMapping("/deleteStu/{id}")
	public String loadStuSave(@PathVariable int id, HttpSession session) {
		boolean f = stuService.deleteStu(id);
		if (f) {
			session.setAttribute("msg", "Student deleted sucessfully");
		} else {
			session.setAttribute("msg", "something went wrong on server");
		}
		return "redirect:/";
	}

}
