package 使用Runable实现多线程;

/**
 * @program: 练习多线程
 * @description: null
 * @author: Wangbobo
 * @created: 2022/06/10 09:05
 */
public class Test implements Runnable {
    @Override
    public void run() {
        System.out.println("我是一个线程");
    }

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(test).start();
    }
}
