Project Title: Homework1 - Dynamic Content Encryption and Decryption

Summary:
The goal of this project is to decrypt dynamically generated content received from a third-party web server. Initially, a request is sent to the server, which responds with encrypted data, including the encryption method and content. The content is decrypted using the specified method to reveal the next dynamic content challenge, which may involve a new encryption method. This project implements various decryption techniques to progress through the challenges.

Technical Design Details:
This web service application is developed in Java and employs encryption and decryption techniques such as base64 encoding, SHA26 encryption, ASCII, ASCII mutation, HEX modification, bitwise manipulations, and scrambled texts with base64 encoding. The project utilizes the strategy design pattern to manage the decryption process effectively. Additionally, a resolver pattern was initially used but later removed from the design.

API Details:
Method: GET
API http://{domain}/v1/pulley/{userId}

Response
    String challenger
    String encryptedPath
    String encryptionMethod
    String expiresIn
    String hint;
    String instructions
    int level


