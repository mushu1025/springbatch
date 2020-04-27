package com.example.batchprocessing;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
/** * Created by maple on 16/5/14. */


public class BatchJob {    
  @Autowired   
  private JobLauncher jobLauncher;  
  @Autowired
  private Job sampleJob;  

  public void run() {       
         try {          
              String dateParam = new Date().toString();       
              JobParameters param = new JobParametersBuilder().addString("date", dateParam).toJobParameters();  
              System.out.println(dateParam);  
              JobExecution execution = jobLauncher.run(sampleJob, param);             //执行job      
              System.out.println("Exit Status : " + execution.getStatus());    
          } catch (Exception e) {   
              e.printStackTrace();   
          } 
     }
}