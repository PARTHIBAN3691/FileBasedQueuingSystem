package com.na.fbqs.exception;

public class NoSuchQueueException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchQueueException(String queueName) {
		super("There is no queue exists with the name: "+queueName);
	}

}
