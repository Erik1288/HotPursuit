package com.eric.lock.interruptable;

public class Writer extends Thread {

    private InterruptableBuffer buff;

    public Writer(InterruptableBuffer buff) {
        this.buff = buff;
    }

    @Override
    public void run() {
        buff.write();
    }
}    