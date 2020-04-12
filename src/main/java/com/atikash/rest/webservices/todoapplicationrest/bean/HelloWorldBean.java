package com.atikash.rest.webservices.todoapplicationrest.bean;

public class HelloWorldBean {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HelloWorldBean(String hello_world) {
    this.message=hello_world;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
