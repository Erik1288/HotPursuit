package com.eric.lock.interruptable;

public class Main {
    public static void main(String[] args) {
        InterruptableBuffer buff = new InterruptableBuffer();

        final Writer writer = new Writer(buff);    
        final Reader reader = new Reader(buff);    
     
        writer.start();    
        reader.start();    
     
        new Thread(new Runnable() {    
     
            @Override    
            public void run() {    
                long start = System.currentTimeMillis();    
                for (;;) {    
                    if (System.currentTimeMillis()    
                            - start > 5000) {    
                        System.out.println("不等了，尝试中断");    
                        reader.interrupt();    
                        break;    
                    } 
                } 
            } 
        }).start();  
    }    
}