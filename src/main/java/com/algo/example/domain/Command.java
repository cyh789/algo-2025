package com.algo.example.domain;

// Command.java
public enum Command {
    WAIT(0), UP(1), RIGHT(2), DOWN(3), LEFT(4), LOAD(5), UNLOAD(6);

    private final int code;
    Command(int code) { this.code = code; }
    public int getCode() { return code; }
}
