package com.pulley.homework1.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.pulley.homework1.Homework1Application;
import com.pulley.homework1.Response.TaskResponse;
import com.pulley.homework1.controller.RestTemplateClient;
import com.pulley.homework1.decoder.DecoderProcessor;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Homework1Application.class)
@SpringBootTest
public class TaskServiceTests {

	@Autowired
	TaskService taskService; 
	
    @MockBean
    private RestTemplateClient restTemplate;	

    @MockBean
    private DecoderProcessor converter;

    @Before
    public void setUp() throws Exception {
    	when(restTemplate.restTemplate().getForObject(any(), any())).thenReturn(null);
    	when(DecoderProcessor.convert(any(), any())).thenReturn("task_91ce441b3aaf7297dba37e226972f443");
    }
    
	@Test
	void testProcessTask() {
		TaskResponse res = new TaskResponse();
		
		res.setEncryptionMethod("nothing");
		res.setEncryptedPath("task_91ce441b3aaf7297dba37e226972f443");
		
		taskService.processTask(res);
	}
}
