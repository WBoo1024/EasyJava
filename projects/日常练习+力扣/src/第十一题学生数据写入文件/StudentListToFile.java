package 第十一题学生数据写入文件;

import 第一题学生.Student;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: 0606
 * @description: 将集合中的学生数据写入到文件中，要去每一个学生对象的数据作为文件中的一行数据。格式：学号，姓名，年龄，居住地
 * @author: Wangbobo
 * @created: 2022/06/08 10:28
 */
public class StudentListToFile {
    public static void main(String[] args) {
        List<Students> list = new ArrayList<>();
        add(list);
        write(list);
    }

    private static void write(List<Students> list) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("src\\第十一题学生数据写入文件\\test.txt");
            for (Students students : list) {
                StringBuffer sb = new StringBuffer();
                fw.write((sb.append("id:").append(students.getId()+"\t").append("姓名：").append(students.getName()+"\t").append("年龄：")
                        .append(students.getAge()+"\t").append("居住地：").append(students.getAddress()+ "\n")).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void add(List<Students> list) {
        list.add(new Students("1", "张三", 23, "北京"));
        list.add(new Students("2", "李四", 24, "上海"));
        list.add(new Students("3", "王五", 25, "广州"));
        list.add(new Students("4", "赵六", 26, "深圳"));
        list.add(new Students("5", "田七", 27, "武汉"));
        list.add(new Students("6", "钱八", 28, "南京"));
        list.add(new Students("7", "孙九", 29, "成都"));
        list.add(new Students("8", "周十", 30, "西安"));
    }
}

class Students {
    private String id;
    private String name;
    private int age;
    private String address;

    public Students(String id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
