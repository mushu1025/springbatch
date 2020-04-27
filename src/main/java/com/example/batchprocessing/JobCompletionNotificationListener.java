package com.example.batchprocessing;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

	private final JdbcTemplate jdbcTemplate;

	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("======================beforeJob");
		if(jobExecution.getStatus() != BatchStatus.COMPLETED) {
			System.out.println("========================failed!!!!!!!!");
		}
		
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("======================afterJob");
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("!!! JOB FINISHED! Time to verify the results");

			jdbcTemplate.query("SELECT first_name, last_name FROM people",
				(rs, row) -> new Person(
					rs.getString(1),
					rs.getString(2))
			).forEach(person -> System.out.println("Found <" + person + "> in the database."));
		}
		System.out.println("======================afterJob");
	}

}
