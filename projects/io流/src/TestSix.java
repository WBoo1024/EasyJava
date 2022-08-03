import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WANG
 * @date 2022/5/27 16:49
 */
public class TestSix {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        list.add("气味儿");
        list.add("阿萨德");
        list.add("案发时");
        OutputStream out = null;
        out = new FileOutputStream("wbwj.txt");
        for (String s:list) {
            out.write(s.getBytes(StandardCharsets.UTF_8));
        }
    }

}
