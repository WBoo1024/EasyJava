import java.util.HashSet;
import java.util.Set;

/**
 * @author WANG
 * @date 2022/5/21 17:20
 */
public class LinkedCircle {
    public static boolean hasCycle(ListNode head) {
        if (null == head || null == head.next){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (null != fast && null != fast.next){
            if (slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;

    }

    public static boolean hasCycle1(ListNode head) {
        if (null == head || null == head.next){
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1,null);
        ListNode node2 = new ListNode(2,null);
        ListNode node3 = new ListNode(3,null);
        ListNode node4 = new ListNode(4,null);
        ListNode node5 = new ListNode(5,null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node6 = new ListNode(6,node1);
        node5.next = node6;
        hasCycle(node1);

    }
}
