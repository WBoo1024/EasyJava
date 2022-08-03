package 第五题统计字符;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: 0606
 * @description: 定义一个泛型为String类型的List集合，统计该集合中每个字符（注意，不是字符串）出现的次数。
 * 例如： 集合中有”abc”、”bcd”两个元素，程序最终输出结 果为：“a = 1,b = 2,c = 2,d = 1”。
 * @author: Wangbobo
 * @created: 2022/06/08 09:15
 */
public class Statistics {
    public static void main(String[] args) {
        String[] strings = {"abc","asd","asdhjas","qwjalskd"};
        List<String> list = new ArrayList<>();
        Collections.addAll(list, strings);
        List<Character> characterList = new ArrayList<>();
        for (String string : list) {
            for (int i = 0; i < string.length(); i++) {
                characterList.add(string.charAt(i));
            }
        }
        for (Character c : characterList) {
            System.out.println(c + " = " + Collections.frequency(characterList, c));
        }
    }
}
