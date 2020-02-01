package com.na.fbqs.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.na.fbqs.repo.Repository;

public class QueueManager {
	
	@Autowired
	private Repository repository;
	
	public QueueManager() {
		
	}
	
	public boolean addQueue(Queue queue) {
		return false;	
	}
	
	public Queue getQueue(String queueName) {
		return null;
	}
	
	public boolean removeQueue(String queueName) {
		return false;
	}
}
