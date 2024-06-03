package com.pulley.homework1.decoder;

import com.pulley.homework1.interfaces.DecoderInterface;

public class DefaultDecoder implements DecoderInterface {
	private String encryptionPath;
	@SuppressWarnings("unused")
	private String encryptionMethod;
	
	public DefaultDecoder(String EncryptionPath, String EncryptionMethod) {
		this.encryptionPath = EncryptionPath;
		this.encryptionMethod = EncryptionMethod;
	}
		
	@Override
	public String decode() {
		return encryptionPath;
	}
}
