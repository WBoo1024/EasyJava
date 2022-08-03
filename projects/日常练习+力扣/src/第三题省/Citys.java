package 第三题省;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: 0606
 * @description: 有2个数组，第一个数组内容为：[黑龙江省,浙江省, 江西省,广东省,福建省]，第二个数组为：[哈尔滨,杭州, 南昌,广州,福州]，将第一个数组元素作为key，第二个数 组元素作为value存储到Map集合中。如{黑龙江省=哈 尔滨, 浙江省=杭州, …}。
 * @author: Wangbobo
 * @created: 2022/06/07 21:14
 */
public class Citys {
    public static void main(String[] args) {
        String[] citys = {"黑龙江省", "浙江省", "江西省", "广东省", "福建省"};
        String[] citys2 = {"哈尔滨", "杭州", "南昌", "广州", "福州"};
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < citys.length; i++) {
            map.put(citys[i], citys2[i]);
        }
        System.out.println(map);
    }
}
