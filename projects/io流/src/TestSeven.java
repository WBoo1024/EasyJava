import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author WANG
 * @date 2022/5/27 17:56
 */
public class TestSeven {
    public static void main(String[] args) throws IOException {
        InputStream is = null;
        is = new FileInputStream("s.txt");
        int len = 0;
        byte[] b = new byte[1024];
        char[] ch = new char[0];
        while ((len = is.read(b)) != -1){
           ch = new String(b, 0, len).toCharArray();
        }
        List<Character> list = new ArrayList<Character>();
        for (char c : ch){
            list.add(c);
        }
        Collections.sort(list);
        OutputStream os = null;
        os = new FileOutputStream("ss.txt");
        for (char c : list){
            os.write(c);
        }
        is.close();
        os.close();
    }
}
