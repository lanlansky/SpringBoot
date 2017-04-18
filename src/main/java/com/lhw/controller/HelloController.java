package com.lhw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lhw.properies.GirlProperies;

@RestController
public class HelloController {
	@Autowired
	private GirlProperies girlProperies;
	//http://127.0.0.1:8081/say?id=100
	//@RequestMapping(value={"/say"},method=RequestMethod.GET)
	@GetMapping("/say")
	//public String say(@RequestParam("id") int id){
	public String say(@RequestParam(value="id",required=false,defaultValue="0") int id){
		return "id: "+id;
		//return girlProperies.getCupSize()+girlProperies.getAge();
	}
	//http://127.0.0.1:8081/23/hi
	//http://127.0.0.1:8081/hello/23
	@RequestMapping(value={"/hello/{id}","/{id}/hi"},method=RequestMethod.GET)
	public String hello(@PathVariable("id") int id){
		return "id: "+id;
		//return girlProperies.getCupSize()+girlProperies.getAge();
	}

}
