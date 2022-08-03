package 第十四题复制文件;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @program: 0606
 * @description: 复制某个目录下的文件，目录中包含子目录以及文件
 * @author: Wangbobo
 * @created: 2022/06/08 14:49
 */
public class CopyFiles {
    public static void main(String[] args) throws IOException {
        File file = new File("src/第十四题复制文件/qwe");
        File file1 = new File("src/第十四题复制文件");
        search(file,file1);
    }

    private static void search(File file,File file1) throws IOException {
        if (file.isDirectory()){
            String srcFileName = file.getName();
            File newFile = new File(file1,srcFileName);
            if (!newFile.exists()) {
                newFile.mkdirs();
            }
            File[] files = file.listFiles();
            for (File fil : files) {
                search(fil,newFile);
            }
        }
        else {
            File newFile = new File(file1,file.getName());
            copy(file,newFile);
        }
    }

    private static void copy(File file,File newFile) throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(newFile);
            char[] chars = new char[1024];
            int i;
            while ((i = fileReader.read(chars)) != -1) {
                fileWriter.write(chars,0, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            fileWriter.close();
            fileReader.close();

        }
    }
}
