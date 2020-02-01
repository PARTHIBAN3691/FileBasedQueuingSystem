package com.na.fbqs.model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.na.fbqs.constants.QueueType;
import com.na.fbqs.factory.QueueFactory;

public class Queue {
	
	private String name;
	
	private BlockingQueue<Record> data;

	public Queue(String name, QueueType queueType) {
		super();
		this.name = name;
		this.data = QueueFactory.getQueue(queueType);
	}
	
}
