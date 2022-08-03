package 同步锁;

/**
 * @program: 0606
 * @description: 练习同步锁
 * @author: Clover
 * @created: 2022/06/07 09:59
 */
public class Test extends Thread{
    private String name = "zhangsan";
    private String pwd = "123456";


    public synchronized void read(){
        System.out.println(Thread.currentThread().getName() + "名字" + name + "编号" + pwd);
    }
    public synchronized void write(String name,String pwd) throws InterruptedException {
        this.name = name;
        Thread.sleep(1000);
        this.pwd = pwd;
        System.out.println(Thread.currentThread().getName() + "名字" + name + "编号" + pwd);
    }
    @Override
    public void run() {
        try {
            write("lisi","123");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Test t = new Test();
        Thread t1 = new Thread(t);
        t1.start();
        Thread.sleep(100);
        t.read();
    }
}

