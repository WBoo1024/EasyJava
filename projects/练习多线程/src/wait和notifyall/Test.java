package wait和notifyall;

/**
 * @program: 练习多线程
 * @description: null
 * @author: Wangbobo
 * @created: 2022/06/10 09:22
 */
public class Test implements Runnable {
    private Object obj;

    public Test(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
           for (int i = 1; i < 53;i++) {
               System.out.println(i);
               if (i%2 == 0) {
                   obj.notifyAll();
                   try {
                       obj.wait(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
        }
    }

    public static void main(String[] args) {
        Object obj = new Object();
        Test test = new Test(obj);
        new Thread(test).start();
        Demo demo = new Demo(obj);
        new Thread(demo).start();
    }
}
class Demo implements Runnable{
private Object obj;
    public Demo(Object obj) {
        this.obj = obj;
    }
    @Override
    public void run() {
        synchronized (obj) {
            for (char i = 'A'; i <='Z'; i++) {
                System.out.println(i);
                    obj.notifyAll();
                    try {
                        obj.wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}
