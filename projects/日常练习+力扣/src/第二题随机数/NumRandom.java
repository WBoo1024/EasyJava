package 第二题随机数;

import java.util.Random;

/**
 * @program: 0606
 * @description: 产生10个1-100的随机数，并放到一个数组中，把数组中大于等于10的数字放到一个list集合中，并打印到控制台。
 * @author: Wangbobo
 * @created: 2022/06/07 21:05
 */
public class NumRandom {
    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[10];
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((n = (random.nextInt(100)+1)) >= 10) {
                nums[i] = n;
                System.out.println(nums[i]);
            }
        }
    }
}
