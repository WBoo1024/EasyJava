import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WANG
 * @date 2022/5/20 20:47
 */
public class Country {
    public static void main(String[] args) {
        Map<String, Map<String,Map<String, List<String>>>> country = new HashMap<>(10);
        Map<String, Map<String,List<String>>> sheng = new HashMap<>(10);
        Map<String, List<String>> wHan = new HashMap<>(10);
        List<String> wuHan = new ArrayList<>();
        wuHan.add("洪山区");
        wuHan.add("青山区");
        wuHan.add("经开区");
        wuHan.add("武昌区");
        wuHan.add("汉阳区");
        wHan.put("武汉市",wuHan);
        Map<String, List<String>> sXi = new HashMap<>(10);
        List<String> xiAn = new ArrayList<>();
        xiAn.add("雁塔区");
        xiAn.add("长安区");
        xiAn.add("渭城区");
        xiAn.add("秦都区");
        xiAn.add("");
        sXi.put("西安市",xiAn);
        Map<String, List<String>> gDong = new HashMap<>(10);
        List<String> gZhou = new ArrayList<>();
        gZhou.add("广州市");
        gZhou.add("深圳市");
        gZhou.add("佛山市");
        gZhou.add("东莞市");
        gDong.put("广州市",gZhou);



        sheng.put("湖北省",wHan);
        sheng.put("陕西省",sXi);
        sheng.put("广东省",gDong);
        country.put("中国",sheng);

        country.forEach((con,shen)->{
            System.out.println("国家：" + con);
            shen.forEach((sh,shi)->{
                System.out.println("\t省：" + sh);
                shi.forEach((s,qu)->{
                    System.out.println("\t\t市" + s);
                    qu.forEach((q)->{
                        System.out.println("\t\t\t" + q);
                    });
                });
            });
        });
    }
}
