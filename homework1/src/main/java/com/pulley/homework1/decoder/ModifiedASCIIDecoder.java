package com.pulley.homework1.decoder;

import com.pulley.homework1.interfaces.DecoderInterface;
import com.pulley.homework1.parser.ParserUtil;

public class ModifiedASCIIDecoder implements DecoderInterface {
	private String encryptionPath;
	private String encryptionMethod;
	private int key;
	
	public ModifiedASCIIDecoder(String EncryptionPath, String EncryptionMethod) {
		this.encryptionPath = EncryptionPath;
		this.encryptionMethod = EncryptionMethod;
		this.key = ParserUtil.getModifierKeyValue(encryptionMethod);
	}
		
	@Override
	public String decode() {
        key = -key;
        
        StringBuilder sb = new StringBuilder();

        for (char c : encryptionPath.toCharArray()) {
            int num = c + (key);
            char modifiedChar = (char) (num);
            sb.append(modifiedChar);
        }

        return sb.toString();
	}   

}
