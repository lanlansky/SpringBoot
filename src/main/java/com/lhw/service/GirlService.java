package com.lhw.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhw.domain.Girl;
import com.lhw.reposity.GirlReposity;

@Service
public class GirlService {
	
	@Autowired
	private GirlReposity girlReposity;
	
	//事务，保证原子性
	@Transactional
	public void insertTwo(){
		Girl girlA=new Girl();
		girlA.setAge(18);
		girlA.setCupSize("B");
		girlReposity.save(girlA);
		
		
		
		
		Girl girlB=new Girl();
		girlB.setAge(19);
		girlB.setCupSize("C");
		girlReposity.save(girlB);
	}

}
