package com.ffcs.ThreadDemo;

/**
 * <p>
 * 二号计数器
 * </p>
 *
 * @author zmc
 * @Since 2023-08-16
 */

public class ForthThread extends Thread{
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
                //TODO 线程二中若是不用死循环，怎么实现
                t2.start();
            }
        }
        //循环结束，退出线程一同时关闭线程二
        MySecondThread.stopThread();
    }


    public static void main(String[] args) {
        ForthThread t1 = new ForthThread();
        t1.setName("First Thread");
        t1.start();
    }

}
