package com.na.fbqs.controller;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.na.fbqs.constants.ReqType;
import com.na.fbqs.exception.NoSuchQueueException;
import com.na.fbqs.model.Message;
import com.na.fbqs.model.Record;
import com.na.fbqs.service.QueueService;

@RequestMapping("/queue")
@RestController
public class QueueController {
	
	@Autowired
	private QueueService queueService;
	
	@PostMapping("/message/{queueName}")
	public ResponseEntity<String> pushMessageToQueue(@RequestBody Message message, @PathVariable("queueName") String queueName, @RequestParam Map<String, String> reqParams) throws NoSuchQueueException{
		
		String clientId = reqParams.get("clientId");
		
		Objects.requireNonNull(clientId, "The sender id can not be empty.");
		Objects.requireNonNull(message, "The message can not be empty.");
		
		Record record = new Record(message, clientId);
		
		boolean success = queueService.postMessage(queueName, record, ReqType.SYNC);
		
		return new ResponseEntity<String>(success?"The message has been posted to the queue successfully.":"Could not post the message, Please retry!", HttpStatus.OK);
	}
	
	
	
	
	
	

}
