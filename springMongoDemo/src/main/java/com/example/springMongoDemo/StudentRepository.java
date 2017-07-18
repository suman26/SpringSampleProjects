package com.example.springMongoDemo;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface StudentRepository extends MongoRepository<Student,Long>,StudentRepositoryCustom{
	Student findFirstByName(String name);
	Student findByAge(int age);
	

}
