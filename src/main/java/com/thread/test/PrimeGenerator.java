package com.thread.test;

import java.util.concurrent.TimeUnit;

/**
 * Created by lirongchao on 2017/11/21.
 */
public class PrimeGenerator extends Thread {

    @Override
    public void run() {
        long num = 1L;
        while (true) {
            if (isPrime(num)) {
                System.out.println("Number %d is Prime = " + num);
            }
            //isInterrupted() 检查线程是否被中断
            if (isInterrupted()) {
                System.out.println("The Prime Generator has been Interrupted");
                return;
            }
            num++;
        }
    }

    /**
     * 判断是否是质数
     * @param num
     * @return true 质数
     * @return false 不是质数
     */
    private boolean isPrime(long num) {
        if (num <= 2) {
            return true;
        }
        if (num % 2 != 0) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Thread thread = new PrimeGenerator();
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
//            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
