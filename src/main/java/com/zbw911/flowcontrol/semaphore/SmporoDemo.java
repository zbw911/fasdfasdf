package com.zbw911.flowcontrol.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author zhangbaowei
 * Create  on 2020/6/22 12:27.
 */
public class SmporoDemo {
    static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 50; i++) {
            executorService.submit(new Task(i));
        }
    }

    static class Task implements Runnable {

        private int i;

        public Task(int i) {

            this.i = i;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(i + " enter");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            semaphore.release();

            System.out.println(i + " out");
        }
    }
}
