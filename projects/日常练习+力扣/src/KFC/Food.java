package KFC;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: 0606
 * @description: 创建一个食物类Food，有存放/获取食物的名称的方法
 * @author: Wangbobo
 * @created: 2022/06/10 14:04
 */
public class Food {
    private String name;

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
