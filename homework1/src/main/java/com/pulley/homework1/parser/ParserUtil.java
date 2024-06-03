package com.pulley.homework1.parser;

public class ParserUtil {
	
    public static Integer getModifierKeyValue(String input) {
        MessageParser msgParser = new MessageParser();
        return msgParser.getInteger(input, "(-?\\d+)");
    }

    public static String getSecretKeyText(String input) {
        MessageParser msgParser = new MessageParser();
        return msgParser.getKeyString(input, "key:\\s*(\\S+)");
    }

    public static String getMessagePackText(String input) {
        MessageParser msgParser = new MessageParser();
        return msgParser.getKeyString(input, "messagepack:\\s*(\\S+)");
    }

}
