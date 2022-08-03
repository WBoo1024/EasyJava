package bank;

import java.io.*;

/**
 * @author WANG
 * @date 2022/5/30 14:04
 */
public class ObjectStudent {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos = null;
        fos = new FileOutputStream("src/bank/student.txt");
        ObjectOutputStream os = null;
       os = new ObjectOutputStream(fos);
       os.writeObject(new Test23(1,"与大学",1123));
       os.writeObject(new Test23(2,"张硕",1224));
       os.close();
       fos.close();
       FileInputStream fis = null;
       fis = new FileInputStream("src/bank/student.txt");
       ObjectInputStream ois = null;
       ois = new ObjectInputStream(fis);
       Test23 test23 = (Test23)ois.readObject();
       System.out.println(test23);
    }
}
