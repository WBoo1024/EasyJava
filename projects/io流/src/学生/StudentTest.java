package 学生;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WANG
 * @date 2022/5/30 10:01
 */
public class StudentTest {
    public static void main(String[] args) throws IOException {
        File file = new File("src/学生/作业");
        File[] files = file.listFiles();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            list.add(files[i].getName());
        }
        /* 学生名字 */
        List<String> listName = new ArrayList<>();
        for (String s:list){
            listName.add(s.substring(0,s.length()-4));
        }
        FileReader fr = null;
        fr = new FileReader("src/学生/学生名单.txt");
        BufferedReader br = null;
        br = new BufferedReader(fr);
        String line = null;
        while ((line = br.readLine()) != null){
            if (!listName.contains(line)){
                System.out.println(line);
            }
        }
    }
}
