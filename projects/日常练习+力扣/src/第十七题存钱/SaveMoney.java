package 第十七题存钱;

/**
 * @program: 0606
 * @description: 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额
 * @author: Wangbobo
 * @created: 2022/06/08 16:40
 */
public class SaveMoney extends Thread {
    private int count;

    public SaveMoney(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            save(1000);
        }
    }

    private synchronized void save(int i) {
        count += i;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "存钱成功，账户余额为" + count);
    }

    public static void main(String[] args) {
        SaveMoney account = new SaveMoney(0);
        Thread t1 = new Thread(account, "第一个储户");
        Thread t2 = new Thread(account, "第二个储户");
        t1.start();
        t2.start();
    }

}