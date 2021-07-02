package com.zbw911.flowcontrol.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // write your code here

        ExecutorService executorService = newFixedThreadPool(5);
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            int no = i + 1;
            Runnable runnable = new Runnable() {

                @Override
                public void run() {
                    System.out.println(no + "准备！");
                    try {
                        begin.await();
                        System.out.println(no + "开跑！");
                        Thread.sleep((long) (Math.random() * 1000));
                        System.out.println(no + "终点！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                }
            };
            executorService.submit(runnable);
        }

        Thread.sleep(1000);

        begin.countDown();
        System.out.println("开跑");
        end.await();
        System.out.println("完成了");
    }
}
