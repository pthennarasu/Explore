package com.pulley.homework1.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pulley.homework1.Response.TaskResponse;
import com.pulley.homework1.constants.Constants;
import com.pulley.homework1.controller.RestTemplateClient;
import com.pulley.homework1.decoder.DecoderProcessor;

import jakarta.ws.rs.core.UriBuilder;

@Service
public class TaskService {
    @Autowired
    private RestTemplateClient restTemplate;	
   
	public void processTask( TaskResponse res ) {
		logResponse(res);
		
		try {
			String endPoint = DecoderProcessor.convert(res.getEncryptedPath(), res.getEncryptionMethod());
			
		    System.out.println( "Response->EndPoint: " + endPoint);
		    
		    if( endPoint != null || !endPoint.isEmpty()) {
				URI uri = UriBuilder.fromUri(Constants.INTERNAL_URL)
						.path(endPoint)
						.build();
				callApi(uri.toString());
		    }
		} catch( Exception e) {
			System.out.println(e.getMessage());
		}
	}

    private TaskResponse callApi(String url) {
    	
    	System.out.println( "Calling new challenge endPoint URL :" + url);
    	
    	TaskResponse res = restTemplate.restTemplate().getForObject(url, TaskResponse.class);
    	
    	return res;
    }
    
	private void logResponse(TaskResponse res) {
		
		System.out.println( "Response->Encryption Method : " + res.getEncryptionMethod());
		
		System.out.println( "Response->Encryption Path   : " + res.getEncryptedPath());
		
		System.out.println( "Response->Hint              : " + res.getHint());
		
		System.out.println( "Response->Instruction       : " + res.getInstructions());
		
	}    

}
