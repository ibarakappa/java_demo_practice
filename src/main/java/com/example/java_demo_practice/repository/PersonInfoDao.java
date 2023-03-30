package com.example.java_demo_practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.java_demo_practice.entity.PersonInfo;

public interface PersonInfoDao extends JpaRepository<PersonInfo, String> {

}
