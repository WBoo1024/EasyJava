package 第十题点名器;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @program: 0606
 * @description: 点名器，有一个文件里面存储了班级同学的姓名，每一个姓名占一行,要求通过程序实现随机点名器
 * @author: Wangbobo
 * @created: 2022/06/08 10:21
 */
public class RandomStudent {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("src\\第十题点名器\\test.txt");
            Scanner scanner = new Scanner(fr);
            List<String> list = new ArrayList<>();
            while (scanner.hasNext()) {
                list.add(scanner.next());
            }
            Random random = new Random();
            int n = random.nextInt(list.size());
            System.out.println(list.get(n));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
