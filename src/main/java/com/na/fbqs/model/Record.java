package com.na.fbqs.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.lang.NonNull;

public class Record {
	
	private UUID recordId;
	
	private String clientId;
	
	private Message message;
	
	private Date timeStamp;
	

	public Record(@NonNull Message message, @NonNull String clientId) {
		super();
		this.timeStamp = new Date();
		this.clientId = clientId;
		this.message = message;
	}

	public UUID getRecordId() {
		return recordId;
	}

	public String getClientId() {
		return clientId;
	}

	public Message getMessage() {
		return message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}
}
