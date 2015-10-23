package me.logx.service.impl;

import org.springframework.stereotype.Service;

import me.logx.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Override
	public void printStudent() {
		System.out.println("invoke printStudent method...");
	}
	
}
