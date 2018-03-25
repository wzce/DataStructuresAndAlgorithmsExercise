package niuke;

/**
 * Created by zuce wei on 2018/3/17.
 */

public class KBackwardsOfLinkedList {
    public static ListNode FindKthToTail(ListNode head,int k) {
        ListNode fastNode=head;
        ListNode followNode=head;
        while (k>0){
            if(fastNode==null){
                return null;
            }
            fastNode=fastNode.next;
            k--;
        }

        while (fastNode!=null){
            fastNode=fastNode.next;
            followNode=followNode.next;
        }
        return followNode;
    }

    public static void main(String s[]){
        ListNode A=new ListNode(1);
        ListNode B=new ListNode(2);
        ListNode C=new ListNode(3);
        ListNode D=new ListNode(4);
        A.next=B;
        B.next=C;
        C.next=D;

        System.out.println(KBackwardsOfLinkedList.FindKthToTail(A,3).val);

    }
}
