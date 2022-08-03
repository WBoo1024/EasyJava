import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: 练习多线程
 * @description: 实现线程通信
 * @author: Wangbobo
 * @created: 2022/06/10 09:24
 */
public class TestTongXin implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int count = 0;
    @Override
    public void run() {

        while (true) {
            lock.lock();
            try {
                if (count > 20) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + count);
                count++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TestTongXin test = new TestTongXin();
        new Thread(test,"A").start();
        new Thread(test,"B").start();
    }
}
