package 递归目录;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 递归查看目录 ,将所有的文件(不是目录) 名,放到一个集合中,再把这个集合的内容写到一个文件中
 *
 * @author WANG
 * @date 2022/5/28 13:49
 */
public class Text {
    private void getName(File file, List<String> list) {
        File[] files = file.listFiles();
        assert files != null;
        for (File f : files) {
            if (f.isFile()) {
                list.add(f.getName());
            } else if (f.isDirectory()) {
                getName(f,list);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Text text = new Text();
        File file = new File("src/递归删除/测试文件夹");
        if (!file.exists()) {
            System.out.println("指定文件不存在");
        }
        List<String> list = new ArrayList<String>();
        text.getName(file, list);
        FileWriter fw = new FileWriter("src/递归删除/测试文件夹/write.txt");
        for (String s:list) {
            System.out.println(s);
            fw.write(s);
            fw.flush();

        }
        fw.close();

    }
}
