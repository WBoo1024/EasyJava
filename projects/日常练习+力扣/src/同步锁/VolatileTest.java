package 同步锁;


/**
 * @program: 0606
 * @description: 练习valatile用法
 * @author: Wangbobo
 * @created: 2022/06/09 09:38
 */
public class VolatileTest extends Thread{
   public volatile boolean flag  = true;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始执行");;

        while (flag) {
            System.out.println(Thread.currentThread().getName() + "执行中");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("执行结束");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        volatileTest.start();
        Thread.sleep(1000);
        volatileTest.flag = false;

        System.out.println("flag赋值为false");
    }
}
