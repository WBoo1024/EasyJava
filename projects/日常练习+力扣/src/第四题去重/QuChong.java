package 第四题去重;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @program: 0606
 * @description: 把如下元素存入List集合 “aaa” “bbb” “aaa” “abc”“xyz” “123” “xyz” 去掉重复元素
 * @author: Wangbobo
 * @created: 2022/06/08 09:07
 */
public class QuChong {
    public static void main(String[] args) {
        String[] strings = {"aaa", "bbb", "aaa", "abc", "xyz", "123", "xyz"};
        List<String> list = new ArrayList<>();
        Collections.addAll(list, strings);
        HashSet<String> set = new HashSet<>(list);
        System.out.println(set);
    }
}
