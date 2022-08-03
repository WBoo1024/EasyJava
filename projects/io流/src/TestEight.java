import java.io.*;

/**
 * @author WANG
 * @date 2022/5/27 20:18
 */
public class TestEight {
    public static void main(String[] args) throws IOException {
        String filename = "src";
        File f = new File(filename);
        if (!f.isDirectory()){
            System.out.println("没有文件夹");
        }
        int lineCount = 0;
        int charCount = 0;
        int numCount = 0;
        int spaceCount = 0;
        int strCount = 0;
        File[] files = f.listFiles();
        assert files != null;
        for (File file : files){
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                lineCount++;
                char[] chars = line.toCharArray();
                for (char c : chars){
                    /* 数字个数 */
                    if (c >= '0' && c<= '9' ) {
                        numCount++;
                        /* 空格ASCII值为 32 */
                    }else if (c == 32) {
                        spaceCount++;
                    }else if (c >= 'A' && c <= 'Z') {
                        charCount++;
                    }else if (c >= 'a' && c <= 'z') {
                        charCount++;
                    }else {
                        strCount++;
                    }
                }
            }
        }
        System.out.println("************");
        System.out.println("目录下一共有" + lineCount + "行内容");
        System.out.println("目录一下一共有" + charCount + "个字母");
        System.out.println("目录一下一共有" + numCount + "个数字");
        System.out.println("目录一下一共有" + spaceCount + "个空格");
        System.out.println("目录一下一共有" + strCount + "个字");
    }
}
