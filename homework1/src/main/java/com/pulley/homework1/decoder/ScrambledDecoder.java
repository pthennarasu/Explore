package com.pulley.homework1.decoder;

import java.util.Base64;

import com.pulley.homework1.interfaces.DecoderInterface;
import com.pulley.homework1.parser.ParserUtil;

public class ScrambledDecoder implements DecoderInterface {
	private String encryptionPath;
	private String encryptionMethod;
	private String messagePack;

	public ScrambledDecoder(String EncryptionPath, String EncryptionMethod) {
		this.encryptionPath = EncryptionPath;
		this.encryptionMethod = EncryptionMethod;
		this.messagePack = ParserUtil.getMessagePackText(encryptionMethod);;
	}
	
	@Override
	public String decode() {
		 // Base64 decode the encodedPositions
        byte[] decodedBytes = Base64.getDecoder().decode(messagePack);
        
        int slen = encryptionPath.length();
        int dlen = decodedBytes.length;
        
        int[] originalPositions = new int[slen];
        
        // remove padding bytes and decode info, what is the beginning 2 bytes value - scratched my head for a while
        System.arraycopy(decodedBytes, dlen-slen, decodedBytes, 0, slen);
        	        
        // Convert byte array to original positions
		 for (int i = 0; i < originalPositions.length; i++) {
		     originalPositions[i] = Byte.toUnsignedInt(decodedBytes[i]);
		 }

        // Unscramble the message using the original positions
        char[] unscrambledMessage = new char[encryptionPath.length()];
        for (int i = 0; i < originalPositions.length; i++) {
            unscrambledMessage[originalPositions[i]] = encryptionPath.charAt(i);
        }
       
        String result = new String(unscrambledMessage);
	    
	    return result;
	}
	
}

