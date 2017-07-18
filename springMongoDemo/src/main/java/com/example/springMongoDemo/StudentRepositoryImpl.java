package com.example.springMongoDemo;

import com.mongodb.WriteResult;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class StudentRepositoryImpl implements StudentRepositoryCustom{

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public int updateStudentAge(String name, int age)
	{
		 Query query = new Query(Criteria.where("name").is(name));
	        Update update = new Update();
	        update.set("age",age);

	        WriteResult result = mongoTemplate.updateFirst(query, update, Student.class);
	        if(result!=null)
	            return result.getN();
	        else
	            return 0;

	}
	@Override
	public int addStudent(Student student)
	{

		if(student!=null)
		{
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(student.getId()));
			query.addCriteria(Criteria.where("name").is(student.getName()));
			if(mongoTemplate.findOne(query, Student.class)==null)
			{ 
			mongoTemplate.insert(student);
			return 1;
			}
		}
		return 0;
	}
	
	
}
