package KFC;

/**
 * @program: 0606
 * @description: 创建一个客户类Customer，继承Thread，重写run方法，在run方法里面进行消费食物操作
 * @author: Wangbobo
 * @created: 2022/06/10 14:05
 */
public class Customer implements Runnable {
    private Kfc kfc;

    public Customer(Kfc kfc) {
        this.kfc = kfc;
    }

    @Override
    public void run() {
        while (true) {
            try {
                kfc.custom();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
