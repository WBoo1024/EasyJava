/**
 * @author WANG
 * @date 2022/5/21 16:46
 */
public class DeleteSort {
    public ListNode deleteSort(ListNode node) {
        ListNode current = node;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        DeleteSort deleteSort = new DeleteSort();


    }
}
