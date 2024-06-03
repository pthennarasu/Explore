package com.pulley.homework1.decoder;

import com.pulley.homework1.interfaces.DecoderInterface;

public class NonHexCharsDecoder implements DecoderInterface {
	private String encryptionPath;
	private String encryptionMethod;

	public NonHexCharsDecoder(String EncryptionPath, String EncryptionMethod) {
		this.encryptionPath = EncryptionPath;
		this.encryptionMethod = EncryptionMethod;

	}

	@Override
    public String decode() {
   	
        StringBuilder sb = new StringBuilder();
        
        for (char c : encryptionPath.toCharArray()) {
            if ((c >= '0' && c <= '9') ||  // Digit
                (c >= 'A' && c <= 'F') ||  // Uppercase A-F
                (c >= 'a' && c <= 'f')) {  // Lowercase a-f
                sb.append(c);
            }
        } 
        
        return sb.toString();
    }
}
