package 第十七题电影票;

/**
 * @program: 0606
 * @description: 多线程模拟影院选位置
 * @author: Wangbobo
 * @created: 2022/06/08 17:16
 */
public class MovieTicket extends Thread {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket <= 0) {
                    break;
                }
                try {
                    System.out.println(Thread.currentThread().getName() + "卖出票号" + ticket--);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        MovieTicket movieTicket = new MovieTicket();
        Thread thread = new Thread(movieTicket, "平台一");
        Thread thread1 = new Thread(movieTicket, "平台二");
        Thread thread2 = new Thread(movieTicket, "平台三");
        Thread thread3 = new Thread(movieTicket, "平台四");
        Thread thread4 = new Thread(movieTicket, "平台五");
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
