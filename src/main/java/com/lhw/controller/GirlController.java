package com.lhw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hazelcast.internal.management.operation.GetMapConfigOperation;
import com.lhw.domain.Girl;
import com.lhw.reposity.GirlReposity;
import com.lhw.service.GirlService;

@RestController
public class GirlController {
	@Autowired
	private GirlReposity girlReposity;
	@Autowired
	private GirlService girlService;
	/*
	 * 查询女生列表
	 */
	@GetMapping("/girls")
	public List<Girl> getALL(){
		return girlReposity.findAll();		
	}
	/*
	 * 添加一个女生
	 */
	@PostMapping("/girls")
	public Girl add(@RequestParam("cupSize") String cupSize,@RequestParam("age") int age){
		Girl girl=new Girl();
		girl.setAge(age);
		girl.setCupSize(cupSize);
		return girlReposity.save(girl);
		
	}
	/**
	 * 查询一个女生
	 * @param id
	 * @return
	 */
	@GetMapping("/girls/{id}")
	public Girl get(@PathVariable("id") int id){		
		return girlReposity.findOne(id);		
	}
	/**
	 * 删除一个女生
	 * @param id
	 */
	@DeleteMapping("/girls/{id}")
	public void delete(@PathVariable("id") int id){
		girlReposity.delete(id);
		
	}
	/**
	 * 更新一个女生
	 * @param id
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PutMapping("girls/{id}")
	public Girl update(@PathVariable("id") int id,
			@RequestParam("cupSize") String cupSize,@RequestParam("age") int age){
		
		Girl girl=new Girl();
		girl.setId(id);
		girl.setAge(age);
		girl.setCupSize(cupSize);
		return girlReposity.save(girl);	
	}
	@GetMapping("/girls/age/{age}")
	public List<Girl> findByAge(@PathVariable("age") int age){
		return girlReposity.findByage(age);	
	}
	@PostMapping("/girls/two")
	public void girlTwo(){		
		girlService.insertTwo();			
	}
	
	

}
