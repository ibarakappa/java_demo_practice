package com.example.java_demo_practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_demo_practice.entity.Bank;

@Repository
public interface BankDao extends JpaRepository<Bank, String> {
	// <Entity, Entity中@Id的資料型態>
}
