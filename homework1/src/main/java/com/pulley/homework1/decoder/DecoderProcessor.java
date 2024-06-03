package com.pulley.homework1.decoder;

import com.pulley.homework1.constants.Constants;
import com.pulley.homework1.interfaces.DecoderInterface;
import com.pulley.homework1.types.EncryptionMethodEnum;

public class DecoderProcessor {

    private static String stripTaskPrefix(String input) {
        if (!input.startsWith(Constants.TASK_PREFIX)) {
            return "Invalid input";
        }
        int startIndex = input.indexOf('_') + 1;
        return input.substring(startIndex);
    }

    private static EncryptionMethodEnum getEncryptionMethod(String encMethod) {
    	if(encMethod.startsWith(EncryptionMethodEnum.MODIFIED_ASCII_WITH_NUMBER.getValue()))
    		return EncryptionMethodEnum.MODIFIED_ASCII_WITH_NUMBER;
    	else if(encMethod.startsWith(EncryptionMethodEnum.XOR_ENCODING.getValue()))
    		return EncryptionMethodEnum.XOR_ENCODING;
    	else if(encMethod.startsWith(EncryptionMethodEnum.SCRAMBLED.getValue()))
    		return EncryptionMethodEnum.SCRAMBLED;
    	else 
    		return EncryptionMethodEnum.fromString(encMethod);
    }

    public static String convert(String encryptedPath, String encryptionMethod) {
        EncryptionMethodEnum encType = getEncryptionMethod(encryptionMethod);
        
        // strip the "task_" part of the path to get the encrypted part only
        encryptedPath = stripTaskPrefix(encryptedPath);
        if (encryptedPath.equals("Invalid input")) return encryptedPath;        
        
        // generic decoder, hmmm
        DecoderInterface decoder = new DefaultDecoder(encryptedPath, encryptionMethod);
        
        switch (encType) {
            case NOTHING:
            	break;
            case ASCII:
            	decoder = new ASCIIDecoder(encryptedPath, encryptionMethod);
            	break;
            case NONHEXCHARS:
            	decoder = new NonHexCharsDecoder(encryptedPath, encryptionMethod);
            	break;
            case MODIFIED_ASCII_WITH_NUMBER:
                decoder = new ModifiedASCIIDecoder(encryptedPath, encryptionMethod);
                break;
            case XOR_ENCODING:
                decoder = new XORDecoder(encryptedPath, encryptionMethod);
                break;
            case SCRAMBLED:
                decoder = new ScrambledDecoder(encryptedPath, encryptionMethod);
        }
       
        return Constants.TASK_PREFIX + decoder.decode();
        
    }
}