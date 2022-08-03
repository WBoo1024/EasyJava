package 递归目录个数;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WANG
 * @date 2022/5/30 14:42
 */
public class Directories {
    public static void getDir(File file,List<File> files){
        if (!file.isDirectory()){
            return;
        }
        File[] fil = file.listFiles();
        for (File f : fil) {
            if (f.isDirectory()) {
                files.add(f);
            } else {
                getDir(f,files);
            }
        }
    }
    public static void main(String[] args) {
        List<File> files = new ArrayList<File>();
        File file = new File("src");
        getDir(file, files);
        System.out.println(files.size());
    }

}
