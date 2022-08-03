package 第十二题文件到集合改进版;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: 0606
 * @description: 将文件中的数据读取到集合中，并遍历集合。要求文件中的每一行数据是学生对象的成员变量值
 * @author: Wangbobo
 * @created: 2022/06/08 10:47
 */
public class FileToStudentList {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        studentRead(list);
        for (Student student : list) {
            System.out.println(student);
        }
    }

    private static void studentRead(List<Student> list) {
        FileReader fr = null;
        try {
            fr = new FileReader("src\\第十二题文件到集合改进版\\test.txt");
            Scanner scanner = new Scanner(fr);
            while (scanner.hasNext()) {
                String[] str = scanner.next().split(",");
                Student student = new Student(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2]),str[3]);
                list.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class Student{
    private int id;
    private String name;
    private int age;
    private String address;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "id:" + id + "\t姓名：" + name + "\t年龄：" + age + "\t地址：" + address;
    }
}
