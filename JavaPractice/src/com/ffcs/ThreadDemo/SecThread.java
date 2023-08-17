package com.ffcs.ThreadDemo;

/**
 * <p>
 * 计数器达到10时，结束线程
 * </p>
 *
 * @author zmc
 * @Since 2023-08-16
 */

public class SecThread extends Thread {
    //计数器
    private static int counter = 0;

    @Override
    public void run(){
        System.out.println(getName() + " start");
        long timeSleep = 500L;
        //计数器达到10时，结束线程
        while (counter < 10) {
            try {
                Thread.sleep(timeSleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter++;
            System.out.println(getName() + "--->" + counter);
        }
    }

    public static void main(String[] args) {
        SecThread t1 = new SecThread();
        t1.setName("First Thread");
        t1.start();
    }

}