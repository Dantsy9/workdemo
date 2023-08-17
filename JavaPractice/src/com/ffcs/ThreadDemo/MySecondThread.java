package com.ffcs.ThreadDemo;

/**
 * <p>
 * 线程二
 * </p>
 *
 * @author zmc
 * @Since 2023-08-16
 */

public class MySecondThread extends Thread {
    private static boolean running;

    public MySecondThread() {
        running = true;
    }

    public void run() {
        System.out.println(getName() + " start");
        while (running) {
            try {
                    Thread.sleep(500L);
                }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName() + " running");
        }

    }

    /**
     * 关闭线程二的循环
     * @date: 2023/8/17
     * @param:
     * @return: 线程二的循环结束参数
     **/
    public static void stopThread() {
        running = false;
    }
}