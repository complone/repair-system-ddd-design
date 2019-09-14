package com.lizhi.guide.util;

public class ThreadNumTest {

    public static void main(String[] args){

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while(threadGroup.getParent() != null){
            threadGroup = threadGroup.getParent();
        }
        int totalThread = threadGroup.activeCount();
        System.out.println(totalThread);
    }


}
