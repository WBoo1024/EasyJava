package 递归删除;

import java.io.File;

/**
 * 递归删除某个目录下的所有的文件（注意：如果是文件夹先删除文件夹中的文件，是空文件夹后才去删除文件夹）
 * @author WANG
 * @date 2022/5/28 13:24
 */
public class Delete {
    public static void main(String[] args) {
        Delete delete = new Delete();
        File file = new File("src/递归删除/测试文件夹");
        if (!file.isDirectory()) {
            System.out.println("找不到文件夹");
        }
        delete.deleteFile(file);
    }
    private void deleteFile(File file){
        File[] files =  file.listFiles();
        assert files != null;
        for (File f : files) {
            if (f.isFile()) {
                System.out.println("文件是否删除：" + f.delete());
            }else {
                deleteFile(f);
            }
            System.out.println( "空目录是否删除："+ f.delete());
        }
    }
}
