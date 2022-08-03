package synchronized同步代码块;

/**
 * @program: 练习多线程
 * @description: null
 * @author: Wangbobo
 * @created: 2022/06/10 09:13
 */
public class Test implements Runnable {
    @Override
    public void run() {
        synchronized (this){
            System.out.println(Thread.currentThread().getName() + "我是一个线程");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(test).start();
        new Thread(test).start();
    }
}

