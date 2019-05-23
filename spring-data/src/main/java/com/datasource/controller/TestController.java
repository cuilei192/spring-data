package com.datasource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datasource.bean.Image;
import com.datasource.bean.MsXxjsdy;
import com.datasource.service.ImageService;
import com.datasource.service.MsXxjsdyService;

@RestController
public class TestController {
	
	@Autowired
	MsXxjsdyService msXxjsdyService;
	
	@Autowired
	ImageService imageService;
	
	
	@RequestMapping("/m")
	public String getMsXxjsdy(int id){
		MsXxjsdy msXxjsdy = msXxjsdyService.getMsXxjsdyById(id);
		return msXxjsdy.toString();
	}
	
	@RequestMapping("/i")
	public String getImg(int id){
		Image image = imageService.getImg(id);
		return image.toString();
	}
	

}
