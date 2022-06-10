package com.lntedutech.mongoapi;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lntedutech.mongoapi.collection.Student;

public interface StudentRepository extends MongoRepository<Student,Integer> {
	

}
