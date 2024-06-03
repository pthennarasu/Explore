package com.pulley.homework1.decoder;

import com.pulley.homework1.interfaces.DecoderInterface;

public class ASCIIDecoder implements DecoderInterface {
	
	private String encryptionPath;
	@SuppressWarnings("unused")
	private String encryptionMethod;

	public ASCIIDecoder(String EncryptionPath, String EncryptionMethod) {
		this.encryptionPath = EncryptionPath;
		this.encryptionMethod = EncryptionMethod;
	}
	
	@Override
	public String decode() {
        // Attempt to extract the part within the brackets
        int startIndex = encryptionPath.indexOf('[') + 1;
        int endIndex = encryptionPath.indexOf(']');
        
        if (startIndex == 0 || endIndex == -1 || endIndex < startIndex) {
            return "Invalid format";
        }

        // Extract the substring that contains the numbers
        String numberSequence = encryptionPath.substring(startIndex, endIndex);
        
        // Split the substring by commas to get individual numbers
        String[] numbers = numberSequence.split(",");
        StringBuilder sb = new StringBuilder();
        
        for (String number : numbers) {
            try {
                int asciiCode = Integer.parseInt(number.trim());
                sb.append((char) asciiCode);
            } catch (NumberFormatException e) {
                return "Invalid number format";
            }
        }

        return sb.toString();
	}
}

