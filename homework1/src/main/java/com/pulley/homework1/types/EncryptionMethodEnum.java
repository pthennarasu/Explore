package com.pulley.homework1.types;

public enum EncryptionMethodEnum {
	
    NOTHING("nothing"), 
    ASCII("converted to a JSON array of ASCII values"),
	NONHEXCHARS("inserted some non-hex characters"),
	MODIFIED_ASCII_WITH_NUMBER("added"), //added X to ASCII value of each character
	XOR_ENCODING("hex decoded"),
	SCRAMBLED("scrambled!"),
	SHA256_HASHED("hashed with sha256, good luck");
	
	private final String value;
	
	EncryptionMethodEnum(String val){
		this.value = val;
	}
	
	public String getValue() {
	    return value;
	}
	
	public static EncryptionMethodEnum fromString(String value) {
	    for (EncryptionMethodEnum method : EncryptionMethodEnum.values()) {
	        if (method.value.equalsIgnoreCase(value)) {
	            return method;
	        }
	    }
	    throw new IllegalArgumentException("Unknown encryption method: " + value);
	}
}
