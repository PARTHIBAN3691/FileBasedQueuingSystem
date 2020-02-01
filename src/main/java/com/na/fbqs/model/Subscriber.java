package com.na.fbqs.model;

public class Subscriber {
	
	private String id;
	
	private EndPoint endPoint;

	public Subscriber(String id, EndPoint endPoint) {
		super();
		this.id = id;
		this.endPoint = endPoint;
	}

	public String getId() {
		return id;
	}

	public EndPoint getEndPoint() {
		return endPoint;
	}
	
}
