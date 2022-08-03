/**
 * @author WANG
 * @date 2022/5/28 11:34
 */
public class Test22 {
    public static void main(String[] args) {
        /* 买法 */
        int way = 1;
        /* 小鸡 */
        int k = 0;
        /* 公鸡数 */
        for (int i = 1; i <= 20; i++) {
            /* 母鸡数 */
            for (int j = 1; j <= 33; j++) {
                /* 一共100只鸡 */
                k = 100 - i - j;
                if (k%3 == 0 && (5*i+3*j+k/3 == 100)) {
                    System.out.println("买法" + way++ + "\t公鸡：" + i + "\t母鸡：" + j + "\t小鸡：" + k);

                }
            }
        }
    }
}
