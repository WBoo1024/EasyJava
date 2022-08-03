package 同步锁;

/**
 * @program: 0606
 * @description: 编写10个线程，第一个线程从1加到10，第二个线程从11加20…第十个线程从91加到100，最后再把10个线程结果相加。
 * @author: Clover
 * @created: 2022/06/07 17:09
 */
public class Num extends Thread {
    private int currNum;
    private static int sum;

    public Num(int currNum) {
        this.currNum = currNum;
    }
    public static synchronized void add(int num){
        sum = num + sum;
    }
    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = currNum + sum + i;
        }
        add(sum);
    }
    public int getSum(){
        return sum;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Num((10*i)+1);
            threads[i].start();
        }
        System.out.println(sum);
    }

}
