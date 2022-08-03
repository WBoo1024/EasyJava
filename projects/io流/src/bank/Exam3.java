package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author WANG
 * @date 2022/5/28 11:49
 */
public class Exam3 {
    public static void main(String[] args) {
        Test23 person = new Test23();
        List<Test23> list = new ArrayList<>();
        list.add(new Test23(101,"祝枝山",10000));
        list.add(new Test23(102,"文征明",20000));
        list.add(new Test23(103,"103",30000));
        HashMap<Integer,Test23> hashMap = new HashMap<>(3);
        for (Test23 test23 : list) {
            hashMap.put(test23.getId(),test23) ;
        }
        Set<Integer> list1 = hashMap.keySet();
        for (Integer l:list1){
            if (l == 102) {
                System.out.println("检索ID为102的储户信息如下：");
                System.out.println(hashMap.get(l));
                System.out.println("遍历哈希表结果如下：");
                for (Test23 t : list) {
                    System.out.println(t);
                }
            }
        }
    }
}
