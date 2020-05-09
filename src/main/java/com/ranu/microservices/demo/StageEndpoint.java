package com.ranu.microservices.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
@Component
@Endpoint(id="stage")
public class StageEndpoint {

	Map<String,Stage> stages = new ConcurrentHashMap<>();
	
	@ReadOperation
	public Map<String,Stage> getAllStages(){		
		return stages;
	}
	@ReadOperation
	public Stage getValue(@Selector String select) {		
		return stages.get(select);
	}
	
	@WriteOperation
	public void setValue(@Selector String select, int satge) {		
		stages.put(select, new Stage(satge));
	}
	
	static class Stage{
		int value;

		public Stage(int value) {
			super();
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
		
	}
}
