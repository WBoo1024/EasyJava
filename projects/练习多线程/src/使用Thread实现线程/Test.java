package 使用Thread实现线程;

/**
 * @program: 练习多线程
 * @description: null
 * @author: Wangbobo
 * @created: 2022/06/10 09:05
 */
public class Test extends Thread {
    @Override
    public void run() {
        System.out.println("我是一个线程");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.start();
    }
}
