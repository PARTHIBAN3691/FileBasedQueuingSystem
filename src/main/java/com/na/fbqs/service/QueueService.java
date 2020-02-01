package com.na.fbqs.service;

import java.net.Authenticator.RequestorType;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.na.fbqs.constants.ReqType;
import com.na.fbqs.exception.NoSuchQueueException;
import com.na.fbqs.model.Record;

@Service
public class QueueService {

	@Autowired
	private QueueManagerService queueManager;

	private boolean put(String queueName, Record record) throws NoSuchQueueException {

		BlockingQueue<Record> queue = queueManager.get(queueName);
		if (queue != null) {
			try {
				queue.put(record);
			} catch (InterruptedException e) {
				// TODO handle error
				e.printStackTrace();
				return false;
			}
		}else {
			throw new NoSuchQueueException(queueName);
		}
		return true;
	}

	private boolean offer(String queueName, Record record) throws NoSuchQueueException {

		BlockingQueue<Record> queue = queueManager.get(queueName);

		if (queue != null) {
			return queue.offer(record);
		} else {
			throw new NoSuchQueueException(queueName);
		}

	}

	public boolean postMessage(String queueName, Record record, ReqType reqType) throws NoSuchQueueException {

		if (ReqType.SYNC.equals(reqType)) {
			return offer(queueName, record);
		} else if (ReqType.ASYNC.equals(reqType)) {
			return put(queueName, record);
		}
		return false;
	}

}
