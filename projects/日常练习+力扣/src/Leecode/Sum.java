import java.util.HashMap;
import java.util.Map;

/** 
 * 统计各字母出现的次数
 * @author WANG
 * @date 2022/5/21 11:59
 */
public class Sum {
    public static void main(String[] args) {
        /* 定义一个字母字符串 */
        String s = "qwewqerasdqweasdgw";
        /* 转换成字符数组 */
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c:ch) {
            if (map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else{
                map.put(c,1);
            }
        }
        map.forEach((k,v)->{
            System.out.println(k+"出现的次数为："+v);
        });
    }
}
