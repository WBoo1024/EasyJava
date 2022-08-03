package 同步锁;

import java.util.Random;

/**
 * @program: 0606
 * @description: 编写多线程应用程序，模拟多个人通过山洞的模拟
 * 这个山洞每次只能通过一个人，每个人通过山洞的时间是5s
 * 随机生成十个人，同时准备过此山洞,显式每次过山洞的人
 * @author: Clover
 * @created: 2022/06/07 16:59
 */
public class Throught implements Runnable {
    public static void main(String[] args) {
        Throught throught = new Throught();
        for (int i = 0; i < 10; i++) {
            new Thread(throught, "第" + i + "个人").start();
        }

    }

    @Override
    public synchronized void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "通过山洞");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
