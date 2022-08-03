package 第十六题天气预报;

import java.util.Random;

/**
 * @program: 0606
 * @description: 编写线程同步模拟应用程序：大气环境数据为：温度，湿度，风速。
 * 一个大气环境传感器测量环境数据需要5秒时间。
 * 一个计算机读取传感器的环境数据需要0.01秒时间。
 * 模拟一个计算机读取大气环境传感器的读取的随机的温度，湿度和风速的100次
 * @author: Wangbobo
 * @created: 2022/06/08 16:01
 */
public class Weather extends Thread{
    public static void main(String[] args) throws InterruptedException {
        Weather weather = new Weather();
        for (int i = 1; i < 101; i++) {
            new Thread(weather,"第"+i+"次").start();
        }
    }
    @Override
    public void run() {
       measure();
    }

    private synchronized void measure() {
        System.out.println(Thread.currentThread().getName() + "读取，请等待5秒");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        int temperature = random.nextInt(100);
        int humidity = random.nextInt(100);
        int windSpeed = random.nextInt(100);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("温度："+temperature+"湿度："+humidity+"风速："+windSpeed);
    }
}
