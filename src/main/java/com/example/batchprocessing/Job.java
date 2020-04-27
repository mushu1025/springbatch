package com.example.batchprocessing;

public class Job {
	private String jobName;
	private String status;
	
	public Job() {
	}
	public Job(String jobName, String status) {
		this.jobName = jobName;
		this.status = status;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
