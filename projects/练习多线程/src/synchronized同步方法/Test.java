package synchronized同步方法;

/**
 * @program: 练习多线程
 * @description: null
 * @author: Wangbobo
 * @created: 2022/06/10 09:10
 */
public class Test implements Runnable {
    @Override
    public synchronized void run() {
        System.out.println("我是一个线程" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(test,"A").start();
        new Thread(test,"B").start();
    }
}

