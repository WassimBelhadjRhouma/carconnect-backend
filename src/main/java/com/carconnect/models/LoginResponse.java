package com.carconnect.models;

public class LoginResponse {
    private String message;
    private String email;
    private String token;
    private String firstName;
    private String lastName;

    public LoginResponse(String message, String email, String token, String firstName, String lastName) {
        this.message = message;
        this.email = email;
        this.token = token;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
}

