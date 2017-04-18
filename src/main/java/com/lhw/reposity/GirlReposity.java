package com.lhw.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lhw.domain.Girl;

public interface GirlReposity extends JpaRepository<Girl, Integer>{
	
	public List<Girl> findByage(int age);

}
