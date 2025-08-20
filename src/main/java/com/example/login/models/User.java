package com.example.login.models;

public class User {
    private String username;
    private String password;
    
    public User() {
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    // Simple validation - in a real application, you would use proper authentication
    public boolean validate() {
        // Demo purposes only - hardcoded credentials
        // In a real application, you would check against a database
        return "admin".equals(username) && "password".equals(password);
    }
}
