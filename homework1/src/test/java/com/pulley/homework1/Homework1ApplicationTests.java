package com.pulley.homework1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.pulley.homework1.decoder.ASCIIDecoder;
import com.pulley.homework1.decoder.ModifiedASCIIDecoder;
import com.pulley.homework1.decoder.ScrambledDecoder;
import com.pulley.homework1.decoder.XORDecoder;
import com.pulley.homework1.service.TaskService;

@ContextConfiguration(classes = Homework1Application.class)
@SpringBootTest
class Homework1ApplicationTests {
	
	@Autowired
	private TaskService taskService;
	
	@Test
	void contextLoads() {
		taskService = new TaskService();
	}

    @Test
    void testASCIIDecoder() {
    	String encryptedMethod = "converted to a JSON array of ASCII values";
    	
    	String encryptedPath = "[78, 78, 90, 29, 40]";
    	
    	ASCIIDecoder decoder = new ASCIIDecoder(encryptedPath, encryptedMethod);
    	
    	String res = decoder.decode();
    	
    	System.out.println("ASCII Decrypted String: " + res);
    }    
	
    @Test
    void testModifiedASCIIDecoder() {
    	String encryptedMethod = "added -6 ";
    	
    	String encryptedPath = ")0/1..\\\\,+Z..-1Y^)10,/Y0]+]-Y/*0-";
    	
    	ModifiedASCIIDecoder decoder = new ModifiedASCIIDecoder(encryptedPath, encryptedMethod);
    	
    	String res = decoder.decode();
    	
    	System.out.println("Modified ASCII Decrypted String: " + res);
    }    

    @Test
    void testXORDecoder() {
    	String encryptedMethod = "hex decoded key: secret";
    	
    	String encryptedPath = "378e17ee8de6e11b1d9f29900972b986";
    	
    	XORDecoder decoder = new XORDecoder(encryptedPath, encryptedMethod);
    	
    	String res = decoder.decode();
    	
    	System.out.println("XOR Decrypted String: " + res);
    }
    
    @Test
    void testScrambledDecoder() {
    	String encryptedMethod = "scrambled! original positions as base64 encoded messagepack: 3AAgGwYaCwITFgUPGREOGA0DHhQECB0BHxcMEBUKEgcAHAk=";
    	
    	String encryptedPath = "91ce441b3aaf7297dba37e226972f443";
    	
    	ScrambledDecoder decoder = new ScrambledDecoder(encryptedPath, encryptedMethod);
    	
    	String res = decoder.decode();
    	
    	System.out.println("Scrambled Decrypted String: " + res);
    }
	
}





























