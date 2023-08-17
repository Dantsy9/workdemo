package com.ffcs.ThreadDemo;

import java.util.Timer;

/**
 * <p>
 * 第一步，创建一个线程，线程外有一个int类型作为计数器，初始值为0。每隔500ms在线程内对计数器进行递增操作。
 * </p>
 *
 * @author zmc
 * @Since 2023-08-16
 */

public class FirstThread extends Thread{

    //计数器
    private static int counter = 0;

    @Override
    public void run(){
        System.out.println(getName() + " start");
        Long timeSleep = 500L;
        while (true) {
            System.out.println(getName() + "--->" + counter);
            try {
                Thread.sleep(timeSleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }
    }

    public static void main(String[] args) {
        FirstThread t1 = new FirstThread();
        t1.setName("First Thread");
        t1.start();
    }

}

