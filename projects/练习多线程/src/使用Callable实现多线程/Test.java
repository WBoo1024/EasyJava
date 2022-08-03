package 使用Callable实现多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: 练习多线程
 * @description: null
 * @author: Wangbobo
 * @created: 2022/06/10 09:06
 */
public class Test implements Callable<String> {
    @Override
    public String call() throws Exception {
        int num = 0;
        for (int i = 0; i < 5; i++) {
            num+=i;
        }
        return "计算结果为：" + num;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Test test = new Test();
        FutureTask<String> futureTask = new FutureTask<>(test);
        new Thread(futureTask).start();
        String str = futureTask.get();
        System.out.println(str);
    }
}
