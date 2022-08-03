package KFC;

/**
 * @program: 0606
 * @description: 创建一个服务员类Waiter，继承Thread，重写run方法，在run方法里面进行生产食物的操作
 * @author: Wangbobo
 * @created: 2022/06/10 14:05
 */
public class Waiter implements Runnable {
    private Kfc kfc;

    public Waiter(Kfc kfc) {
        this.kfc = kfc;
    }

    @Override
    public void run() {
        while (true) {
        try {
            kfc.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }
}
