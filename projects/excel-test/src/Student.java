import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author WANG
 * @date 2022/5/31 17:34
 */
@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String sex;
    private String age;
    private String study;
    private String num;

    public Student() {
    }
}
