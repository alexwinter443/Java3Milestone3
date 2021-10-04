package com.gcu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gcu.model.UserModel;

@SpringBootApplication
public class MilestoneApplication {
	
	List<UserModel> list=new ArrayList<UserModel>();  

	public static void main(String[] args) {
		SpringApplication.run(MilestoneApplication.class, args);
	}

}
