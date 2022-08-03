package 复制文件夹;

import java.io.File;

/**
 * 将指定的文件夹和文件全部复制到另一个位置
 *
 * @author WANG
 * @date 2022/5/31 14:28
 */
public class CopyFile {
    public static void main(String[] args) {
        File file = new File("D:/123/a");
        File fil = new File("D:/123/copy");
        getFile(file,fil);
    }
    /**
     *
     * 递归获取所有的文件
     * @param file  传入一个文件对象
     */
    private static void getFile(File file,File fil) {
        File[] files = file.listFiles();
        for (File f : files){
            if (f.isDirectory()) {
                getFile(f,fil);
            }else if (f.isFile()){
                renameFile(f,fil);
            }
        }
    }
    /**
     *将文件复制到指定路径
     *
     * @param f 传入一个文件对象
     * @param fil  指定文件路径
     */
    private static void renameFile(File f, File fil) {
        System.out.println(f.renameTo(new File(String.valueOf(getPath(f, fil)))));
    }

    /**
     * 获取文件的新路径
     * @param f 传入一个文件对象
     * @param fil 指定的文件对象
     * @return  复制后的路径
     */
    private static File getPath(File f, File fil) {
        String s = f.getPath().substring(9,f.getPath().length());
        String str = fil.getAbsolutePath();
        File newFile = new File(str + File.separator + s);
        String path = newFile.getAbsolutePath();
        File file = new File(path.substring(0,path.length() - f.getName().length()));
        if (!file.exists()) {
            file.mkdirs();
        }
        return newFile;
    }
}
