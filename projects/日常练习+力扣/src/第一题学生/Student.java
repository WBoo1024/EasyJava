package 第一题学生;

/**
 * @program: 0606
 * @description: 使用List集合存储10个学生信息。学生信息：姓名， 年龄，成绩。统计所有姓“张”的同学的平均成绩。
 * @author: Clover
 * @created: 2022/06/07 20:28
 */
public class Student {
    private String name;
    private int age;
    private int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Student[] students = new Student[9];
        studentAdd(students);
        double sum = 0;
        int count = 0;
        for (Student student : students) {
            if((student.getName().toCharArray())[0] == '张'){
                    sum += student.getScore();
                    count++;
            }
        }
        System.out.println("平均成绩为：" + (sum/count));
    }

    public static void studentAdd(Student[] students) {
        students[0] = new Student("张三", 18, 100);
        students[1] = new Student("李四", 19, 99);
        students[2] = new Student("王五", 20, 98);
        students[3] = new Student("张六", 21, 97);
        students[4] = new Student("孙七", 22, 96);
        students[5] = new Student("周八", 23, 95);
        students[6] = new Student("吴九", 24, 94);
        students[7] = new Student("张十", 25, 93);
        students[8] = new Student("王二十", 26, 92);
    }
}
