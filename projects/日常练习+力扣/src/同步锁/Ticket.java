package 同步锁;

import java.util.Random;

/**
 * @program: 0606
 * @description: 假设火车站有100张票，现在有5个售票点同时售票
 * 打印出每个售票点所卖出的票号,各售票点不能售出相同票号的火车票
 * @author: Clover
 * @created: 2022/06/07 16:11
 */

class TicketSale implements Runnable {
    private int ticket = 100;
    private boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        TicketSale ticketSale = new TicketSale();
        Thread t1 = new Thread(ticketSale,"售票点1");
        Thread t2 = new Thread(ticketSale,"售票点2");
        Thread t3 = new Thread(ticketSale,"售票点3");
        Thread t4 = new Thread(ticketSale,"售票点4");
        Thread t5 = new Thread(ticketSale,"售票点5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
    @Override
    public  void run() {
        while (flag) {
            synchronized (this){
                    if (ticket <= 0) {
                        flag = false;
                        return;
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


}
