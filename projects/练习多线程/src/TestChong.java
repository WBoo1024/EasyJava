import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: 练习多线程
 * @description: 实现线程安全
 * @author: Wangbobo
 * @created: 2022/06/10 09:18
 */
public class TestChong implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "我是一个线程");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TestChong test = new TestChong();
        new Thread(test).start();
        new Thread(test).start();
    }
}

