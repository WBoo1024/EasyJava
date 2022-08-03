package 同步锁;

/**
 * @program: 0606
 * @description: 双线程轮流输出1-100
 * @author: Wangbobo
 * @created: 2022/06/09 20:26
 */
public class Number implements Runnable{
    private  int num = 0;
    @Override
    public void run() {
        notifyAll();
        while (true) {
            synchronized (this){if (num >= 101) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "输出" + ++num);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                notifyAll();
            }}
        }
    }

    public static void main(String[] args) {
        Number number = new Number();
        Thread thread = new Thread(number,"A");
        Thread thread1 = new Thread(number,"B");
        thread.start();
        thread1.start();
    }
}
