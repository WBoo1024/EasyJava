package 路径写入;

import java.io.*;

/**
 * 进入某一个目录下，找到所有的a文件夹
 * 并且在这个文件夹下创建一个a.txt文件
 * 并且把其父路径写入文件中
 * @author WANG
 * @date 2022/5/30 17:47
 */
public class WritePath {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/123/a");
        getDir(file);
    }

    /**
     * 递归获取文件夹
     * @param file 传入一个文件对象
     */
    public static void getDir(File file) throws IOException {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    getA(f);
                    getDir(f);
                }
            }
        } else {
            System.out.println("指定文件不存在");
        }
    }

    /**
     * 判断文件夹名字是否含有a
     * @param f 传入一个文件夹对象
     */
    public static void getA(File f) throws IOException {
        char[] chars = f.getName().toCharArray();
        for (char aChar : chars) {
            if (aChar == 'a') {
                creatTxt(f);
                break;
            }
        }
    }

    /**
     * 在a文件夹下建一个a文件
     * @param f 传入一个a文件夹对象
     * @throws IOException 抛出IO异常
     */
    public static void creatTxt(File f)  {
        FileWriter fw = null;
        OutputStream out = null;
        try {
            out = new FileOutputStream(f.getAbsolutePath());
        } catch (FileNotFoundException e) {
            System.out.println("为止错误");
            e.printStackTrace();
        }
        try {
            fw = new FileWriter(f.getAbsolutePath() + File.separator + "a.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.write(f.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
