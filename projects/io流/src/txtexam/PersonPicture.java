package txtexam;

import java.io.*;
import java.util.*;

/**
 * 有一个记事本文件,里面是人员名单
 * 有一个文件夹,里面是人员的照片,照片的在命名的时候,含有这个人的姓名信息
 * 写一个程序,将名单中有照片的人的照片选出来,存到一个文件夹里
 * @author WANG
 * @date 2022/5/28 14:33
 */
public class PersonPicture {
    @Override
    public String toString() {
        return "PersonPicture{}";
    }

    public static void main(String[] args) throws IOException {
        File file = new File("src/txtexam/picture");
        if (!file.exists()) {
            System.out.println("指定文件未找到");
        }
        /* 获取照片文件列表 */
        File[] files = file.listFiles();
        assert files != null;
        /* 将照片名li集合 */
        List<String> li = new ArrayList<String>();
        for (File f : files) {
            li.add(f.getName());
        }
        /* 从照片名中截取姓名信息，存入list集合中 */
        List<String> list = new ArrayList<String>();
        for (String f : li) {
            list.add(f.substring(0,(f.length()-4)));
        }
        /* 读取名单文件 */
        FileReader fr = new FileReader("src/txtexam/person.txt");
        BufferedReader br = new BufferedReader(fr);
        /* 对名单进行一行一行读取 */
        String string;
        while ((string = br.readLine()) != null){
            /* 遍历照片名集合 */
            for (String str:list){
                /* 判断名单和照片名是否相同 */
                if (str.equals(string)){
                    StringBuilder sb = new StringBuilder();
                    sb.append(string).append(".png");
                    File f = new File("src/txtexam/picture/"+sb);
                    System.out.println(f.renameTo(new File("src/txtexam/remove/"+sb)));
                }
            }
        }
    }
}
