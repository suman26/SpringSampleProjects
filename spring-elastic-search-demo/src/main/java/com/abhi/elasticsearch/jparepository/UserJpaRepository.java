package com.abhi.elasticsearch.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.elasticsearch.model.Users;

public interface UserJpaRepository  extends JpaRepository<Users,Long>{

}
