package 第十三题数据排序;


import java.io.FileWriter;
import java.util.*;



/**
 * @program: 0606
 * @description: 键盘录入5个学生信息（姓名，语文成绩，数学成绩，英语成绩），要去按照成绩总分从高到底写入文件中，格式：姓名，语文成绩，数学成绩，英语成绩
 * @author: Wangbobo
 * @created: 2022/06/08 14:06
 */
public class StudentSort {
    public static void main(String[] args) {
        System.out.println("请输入学生信息，输入quit结束输入");
        List<Student> list = new ArrayList<>();
        studentAdd(list);
        TreeSet<Student> treeSet = new TreeSet<>(list);
        writeFile(treeSet);
    }
    /**
     * @Description: 将学生数据写入到文件中
     * @date: 2022/6/8 14:42
     * @param treeSet 学生数据集合
     */
    private static void writeFile(TreeSet<Student> treeSet) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/第十三题数据排序/student.txt");
            StringBuffer stringBuffer = new StringBuffer();
            for (Student student : treeSet) {
                String str = stringBuffer.append("姓名：").append(student.getName()).append(",").append("语文成绩：")
                        .append(student.getChinese()).append(",").append("数学成绩：").append(student.getMath()).append(",")
                        .append("英语成绩：").append(student.getEnglish()).append("\r\n").toString();
                fileWriter.write(str);
            }
            System.out.println("写入成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @Description: 控制面板输入学生信息
     * @date: 2022/6/8 14:22
     */
    private static void studentAdd(List<Student> list) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.next();
            if ("quit".equals(str)) {
                break;
            }
            String[] split = str.split(",");
            Student student = new Student(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
            list.add(student);
        }
    }

}

class Student implements Comparable<Student> {
    private String name;
    private int chinese;
    private int math;
    private int english;

    public Student(String name, int chinese, int math, int english) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public String getName() {
        return name;
    }

    public int getChinese() {
        return chinese;
    }

    public int getMath() {
        return math;
    }

    public int getEnglish() {
        return english;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return chinese == student.chinese && math == student.math && english == student.english;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chinese, math, english);
    }

    @Override
    public int compareTo(Student o) {
        return o.getChinese() + o.getMath() + o.getEnglish() - this.getChinese() - this.getMath() - this.getEnglish();
    }

    @Override
    public String toString() {
        return "姓名：" + name + "\t语文成绩：" + chinese + "\t数学成绩：" + math + "\t英语成绩：" + english;
    }
}
