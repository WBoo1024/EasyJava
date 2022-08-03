import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author WANG
 * @date 2022/5/27 15:12
 */
public class TextOne {
    public static void main(String[] args) throws IOException {
        OutputStream out = null;
        try {
            out = new FileOutputStream("Hello.txt");
            String s = "HelloJavaWorld";
            out.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert out != null;
            out.close();
        }
    }
}
