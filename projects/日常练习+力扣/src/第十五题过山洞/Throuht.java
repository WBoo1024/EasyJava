package 第十五题过山洞;

/**
 * @program: 0606
 * @description: 编写多线程应用程序，模拟多个人通过一个山洞的模拟。
 * 这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒，随机生成10个人，同时准备过此山洞， 显示一下每次通过山洞人的姓名
 * @author: Wangbobo
 * @created: 2022/06/08 15:48
 */
public class Throuht extends Thread {
    public static void main(String[] args) {
        String[] str = {"张三","李四","王五","赵六","钱七","孙八","周九","吴十","郑十一","李十二"};
        Throuht throuht = new Throuht();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(throuht,str[i]);
            thread.start();
        }
    }
    @Override
    public synchronized void run() {
            try {
                System.out.println(Thread.currentThread().getName()+"通过山洞");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

