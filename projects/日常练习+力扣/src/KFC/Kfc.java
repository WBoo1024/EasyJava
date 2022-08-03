package KFC;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: 0606
 * @description: 创建一个KFC类，有生产食物和消费食物的方法
 * @author: Wangbobo
 * @created: 2022/06/10 14:03
 */
public class Kfc {
    private String[] name = {"可乐", "炸鸡", "鸡腿堡", "牛肉堡", "薯条", "鸡腿", "鸡肉块"};
    private List<Food> foods = new ArrayList<>(0);
    private Random random = new Random();

    public synchronized void produce() throws InterruptedException {
            if (foods.size() == 20) {
                System.out.println("食物已经满了，不能生产了");
                wait();
            }
            Food f = new Food(name[random.nextInt(name.length)]);
            foods.add(f);
            System.out.println(Thread.currentThread().getName() + "生产了一个食物");
            Thread.sleep(1000);
            notify();
    }

    public synchronized void custom() throws InterruptedException {
            if (foods.size() == 0) {
                System.out.println("食物已经空了，不能消费了");
                wait();
            }
            Food f = new Food(name[random.nextInt(name.length)]);
            foods.remove(f);
            System.out.println(Thread.currentThread().getName() + "消费了一个食物");
            Thread.sleep(2000);
            notify();
    }

}

class Test {
    public static void main(String[] args) {
        Kfc kfc = new Kfc();
        for (int i = 0; i < 3; i++) {
            new Thread(new Waiter(kfc),"厨师" + i).start();
        }
for (int i = 0; i < 3; i++) {
    new Thread(new Customer(kfc),"顾客" + i).start();

}

    }
}