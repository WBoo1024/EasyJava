import java.util.Stack;

/**
 * @author WANG
 * @date 2022/5/21 17:21
 */
public class KuoHao {
    public static boolean isValid(String s) {
        char[] arrays = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c:arrays) {
            if (c == '{'){
                stack.push('}');
            }else if (c == '['){
                stack.push(']');
            }else if (c == '('){
                stack.push(')');
            }else if (stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("."));
    }
}
