package com.ffcs.ThreadDemo;

/**
 * <p>
 * 创建一个新的线程 MySecondThread ，在计数器达到5的时候启动
 * </p>
 *
 * @author zmc
 * @Since 2023-08-16
 */

public class ThirdThread extends Thread{

    //计数器
    private static int counter = 0;
    @Override
    public void run(){

        System.out.println(getName() + " start");
        long timeSleep = 500L;
        while (counter < 10) {
            try {
                Thread.sleep(timeSleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter++;
            System.out.println(getName() + "--->" + counter);
            //计数器到达5，启动线程二
            if (counter == 5){
                MySecondThread t2 = new MySecondThread();
                t2.setName("Second Thread");
                t2.start();
            }
        }
    }


    public static void main(String[] args) {
        ThirdThread t1 = new ThirdThread();
        t1.setName("First Thread");
        t1.start();
    }

}