import java.io.*;

/**
 * @author WANG
 * @date 2022/5/27 15:23
 */
public class TextTwo {
    public static void main(String[] args) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        int length = 0;
        try {
            /* 读取，输入流 */
            is = new FileInputStream("C:\\Users\\WANG\\Desktop\\1.jpg");
            /* 写入，输出流 */
            os = new FileOutputStream("copy.png");
            byte[] b = new byte[1024];
            while ((length = is.read(b)) != -1){
                os.write(b, 0, length);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("找不到指定文件");
        }finally {
            assert os != null;
            os.close();
            is.close();
        }
    }
}
