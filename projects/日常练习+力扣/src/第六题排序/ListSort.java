package 第六题排序;

import java.util.*;

/**
 * @program: 0606
 * @description: 在一个集合中存储了无序并且重复的字符串，定义 一个方法，让其有序（字典排序）还不能去除重复的元素输出。
 * @author: Wangbobo
 * @created: 2022/06/08 09:35
 */
public class ListSort {
    public static void main(String[] args) {
        String[] strings = {"aaa", "bbb", "aaa", "abc", "xyz", "123", "xyz"};
        List<String> list = new ArrayList<>();
        for (String s : strings) {
            list.add(s);
        }
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = o1.compareTo(o2);
                return i == 0 ? 1 : i;
            }
        });
        treeSet.addAll(list);
        System.out.println(treeSet);
    }
}
