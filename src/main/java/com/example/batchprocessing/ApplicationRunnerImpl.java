package com.example.batchprocessing;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
	
	@SuppressWarnings("resource")
	@Override
    public void run(ApplicationArguments args) throws Exception {
    	new ClassPathXmlApplicationContext("classpath:spring-batch2.xml");
    }
   
}