package 第八题集合到文件;

import java.io.FileWriter;
import java.util.ArrayList;

/**
 * @program: 0606
 * @description: 集合到文件，将ArrayList集合中的元素添加到文本，每添加一个元素进行一次换行
 * @author: Wangbobo
 * @created: 2022/06/08 10:01
 */
public class ListToFile {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
        list.add("fff");
        list.add("ggg");
        list.add("hhh");
        list.add("iii");
        list.add("jjj");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/第八题集合到文件/test.txt");
            for (String str : list) {
                fileWriter.write(str + "\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
