import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author WANG
 * @date 2022/5/26 11:56
 */
public class Test {
    public static void main(String[] args) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        int length = 0;
        try {
            /* 读取，输入流 */
            new FileInputStream("C:\\Users\\WANG\\Desktop\\1.jpg");
            /* 写入，输出流 */
            os = new FileOutputStream("C:\\Users\\WANG\\Desktop\\copy.png");
            byte[] b = new byte[1024];
            while ((length = is.read(b)) != -1){
                os.write(b, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert os != null;
            os.close();
            is.close();
        }
    }
}
