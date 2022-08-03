package 线程;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: 0606
 * @description: 学习线程
 * @author: Clover
 * @created: 2022/06/06 16:22
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        myThread.setName("线程1");
        System.out.println("线程1启动" + System.currentTimeMillis());
        myThread.start();


        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.setName("线程2");

        thread.start();
        System.out.println("线程结束" + System.currentTimeMillis());
        MyThread3 myThread3 = new MyThread3();
        FutureTask<String> futureTask = new FutureTask<>(myThread3);
        Thread thread1 = new Thread(futureTask);
        thread1.setName("线程3");
        thread1.start();
        System.out.println(futureTask.get());
        System.out.println("线程1已结束" + System.currentTimeMillis());
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Mythread" + System.currentTimeMillis());
        }

    }

    static class MyThread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("MyThread2" + System.currentTimeMillis());
        }
    }

    static class MyThread3 implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "MyThread3" + System.currentTimeMillis();
        }
    }
}

