package com.pulley.homework1.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pulley.homework1.Response.TaskResponse;
import com.pulley.homework1.constants.Constants;
import com.pulley.homework1.service.TaskService;

import jakarta.ws.rs.core.UriBuilder;

@RestController
@RequestMapping("/")
public class TaskController {

    @Autowired
    private RestTemplateClient restTemplate;
    
    @Autowired
    private TaskService taskService;

    @GetMapping("/pulley/{taskId}")
    public TaskResponse getTask(@PathVariable String taskId) {
 
		URI uri = UriBuilder.fromUri(Constants.EXTERNAL_URL)
				.path(taskId)
				.build();
		    	
    	TaskResponse res = restTemplate.restTemplate().getForObject(uri.toString(), TaskResponse.class);
        
    	if( res != null )
       		taskService.processTask(res);
        
        return res;    
    }
    
};


