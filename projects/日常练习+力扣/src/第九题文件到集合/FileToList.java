package 第九题文件到集合;

import java.io.FileReader;
import java.util.*;

/**
 * @program: 0606
 * @description: 文件到集合，把文本文件中的数据读取到集合中
 * 并遍历集合。要求：文件中每一行数据是一个集合元素
 * @author: Wangbobo
 * @created: 2022/06/08 10:07
 */
public class FileToList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader("src\\第八题集合到文件\\test.txt");
            Scanner scanner = new Scanner(fr);
            while (scanner.hasNext()) {
                list.add(scanner.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(list);
    }


}
