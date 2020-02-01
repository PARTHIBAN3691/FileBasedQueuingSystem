package com.na.fbqs.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QueueSubscriber {
	
	private Map<String, Set<String>> queueSubscriberMap;
	
	private QueueSubscriber() {
		this.queueSubscriberMap = new HashMap<String, Set<String>>();
	}
	
	//TODO 
	public boolean addSubscriber(String queueName, String subscriberId) {
		Set<String> subscriberIds = queueSubscriberMap.get(queueName);
		
		if(!subscriberIds.contains(subscriberId)) {
			subscriberIds.add(subscriberId);
		}else {
			//TODO give the message to the user.
		}
		
		subscriberIds.add(subscriberId);
		return false;
	}
	

}
