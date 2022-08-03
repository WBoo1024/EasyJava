import java.io.File;
import java.io.IOException;

/**
 * @author WANG
 * @date 2022/5/27 15:31
 */
public class TextFive {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\HelloWorld.txt");
        file.createNewFile();
        System.out.println(file.isFile());
        File file1 = new File("D:\\IOTest");
        file1.mkdirs();
        System.out.println(file1.isDirectory());
        System.out.println(file.renameTo(new File(file1.getAbsolutePath()+"\\HelloWorld.txt")));
    }
}
