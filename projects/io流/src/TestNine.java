import java.io.*;

/**
 * @author WANG
 * @date 2022/5/27 21:14
 */
public class TestNine {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\123\\123.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        System.out.println(file.exists());
        System.out.println(file.separator + file.getName());
        System.out.println(file.length() + file.lastModified());
        FileReader fr = new FileReader(file);
        int len;
        while ((len = fr.read()) != -1) {
            System.out.print((char)len);
        }
        fr.close();
        FileWriter fileWriter = new FileWriter("D:\\123\\123123145.txt");
        String s = "my" +
                "name" +
                "is" +
                "wang" +
                "bo" +
                "bo";
        fileWriter.write(s);
        fileWriter.close();
    }
}
