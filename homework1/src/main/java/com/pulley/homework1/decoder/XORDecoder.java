package com.pulley.homework1.decoder;

import java.nio.charset.StandardCharsets;

import com.pulley.homework1.interfaces.DecoderInterface;
import com.pulley.homework1.parser.ParserUtil;

public class XORDecoder implements DecoderInterface {
	
	private String encryptionPath;
	private String encryptionMethod;
	private String key;

	public XORDecoder(String EncryptionPath, String EncryptionMethod) {
		this.encryptionPath = EncryptionPath;
		this.encryptionMethod = EncryptionMethod;
		this.key = ParserUtil.getSecretKeyText(encryptionMethod);

	}
	
	@Override
    public String decode() {

        byte[] hexDecodedBytes = hexStringToByteArray(encryptionPath);

        byte[] decryptedBytes = xorWithKey(hexDecodedBytes, key.getBytes(StandardCharsets.UTF_8));
        
        String decryptedString = byteArrayToHexString(decryptedBytes);

        return decryptedString;
    }

    // Convert a hex string to a byte array
    private static byte[] hexStringToByteArray(String hex) {
        int length = hex.length();
        byte[] data = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            
        	// better for debugging purpose, otherwise one line would be okay
            int firstDigit = toDigit(hex.charAt(i));
            int secondDigit = toDigit(hex.charAt(i+1));
        	
            data[i / 2] = (byte) ((firstDigit << 4) + secondDigit);
        }
        return data;
    }
    
    private static int toDigit(char hexChar) {
        int digit = Character.digit(hexChar, 16);
        if(digit == -1) {
            throw new IllegalArgumentException(
              "Invalid Hexadecimal Character: "+ hexChar);
        }
        return digit;
    }
    
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    // XOR a byte array with a key
    private static byte[] xorWithKey(byte[] data, byte[] key) {
        byte[] result = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = (byte) (data[i] ^ key[i % key.length]); // scratching my head for a while to discover this, cool :)
        }
        return result;
    }
}