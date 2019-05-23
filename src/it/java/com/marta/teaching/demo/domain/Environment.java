package com.marta.teaching.demo.domain;

public enum Environment {
    LOCAL("local"),
    TEST("test");

    private String value;

    private Environment(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
