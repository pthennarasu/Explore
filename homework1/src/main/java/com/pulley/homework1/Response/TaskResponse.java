package com.pulley.homework1.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskResponse {

    private String challenger;

    @JsonProperty("encrypted_path")
    private String encryptedPath;

    @JsonProperty("encryption_method")
    private String encryptionMethod;

    @JsonProperty("expires_in")
    private String expiresIn;

    private String hint;

    private String instructions;

    private int level;

    // Getters and Setters
    public String getChallenger() {
        return challenger;
    }

    public void setChallenger(String challenger) {
        this.challenger = challenger;
    }

    public String getEncryptedPath() {
        return encryptedPath;
    }

    public void setEncryptedPath(String encryptedPath) {
        this.encryptedPath = encryptedPath;
    }

    public String getEncryptionMethod() {
        return encryptionMethod;
    }

    public void setEncryptionMethod(String encryptionMethod) {
        this.encryptionMethod = encryptionMethod;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}