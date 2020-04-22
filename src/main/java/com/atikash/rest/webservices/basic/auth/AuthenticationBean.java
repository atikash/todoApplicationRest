package com.atikash.rest.webservices.basic.auth;

public class AuthenticationBean {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AuthenticationBean(String hello_world) {
    this.message=hello_world;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
