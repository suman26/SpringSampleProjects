package com.example.springMongoDemo;

public interface StudentRepositoryCustom  {
	public int updateStudentAge(String name, int age);
	public int addStudent(Student student);
}
