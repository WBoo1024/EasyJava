import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author WANG
 * @date 2022/5/27 15:30
 */
public class TextThree {
    public static void main(String[] args) throws IOException, IOException {
        InputStream is = null;
        is = new FileInputStream("CharNum.txt");
        int i = 0;
        int n = 0;
        int l = 0;
        while (is.read() != -1) {
            l = is.read();
            if (l == 65) {
                i++;
            } else if (l == 97){
                n++;
            }
        }
        System.out.println("A的次数为" + i);
        System.out.println("a的次数为" + n);
    }
}

