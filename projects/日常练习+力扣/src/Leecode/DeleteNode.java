
/**
 * @author WANG
 * @date 2022/5/21 17:16
 */
public class DeleteNode {
    private void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
