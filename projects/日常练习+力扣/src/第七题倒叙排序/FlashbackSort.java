package 第七题倒叙排序;

import java.util.*;

/**
 * @program: 0606
 * @description: 程序启动之后，可以从键盘输入接收多个整数
 * 直到输入quit的时结束输入，把输入过的整数倒序排序输出。
 * @author: Wangbobo
 * @created: 2022/06/08 09:46
 */
public class FlashbackSort {
    public static void main(String[] args) {
        System.out.println("请输入整数，输入quit结束输入");
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (true) {
            String str = scanner.next();
            if (str.equals("quit")) {
                break;
            }
            list.add(Integer.parseInt(str));
        }
        list.sort((o1, o2) -> o2 - o1);
        System.out.println(list);
    }
}
