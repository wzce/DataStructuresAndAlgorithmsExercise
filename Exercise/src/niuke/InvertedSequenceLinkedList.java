package niuke;

import java.util.ArrayList;

/**
 * Created by zuce wei on 2018/3/16.
 */



public class InvertedSequenceLinkedList {
    public static  ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList();
        if(listNode==null){
            return res;//保证链表不是空的对象实例
        }
        ListNode first=listNode;
        ListNode next;
        ListNode rem=listNode.next;//剩余的尾串
        first.next=null;

        while (rem != null) {
            next=rem;
            rem=rem.next;
            next.next=first;
            first=next;
        }
        while (first!=null){
            res.add(first.val);
            first=first.next;
        }
        return res;
    }

    public static ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode front=head;
        ListNode rem=head.next;
        front.next=null;
        ListNode tmp;
        while(rem!=null){
            tmp=rem;
            rem=rem.next;
            tmp.next=front;
            front=tmp;
        }
        return front;
    }

    public static void main(String s[]){
        ListNode A=new ListNode(1);
        ListNode B=new ListNode(2);
        ListNode C=new ListNode(3);
        A.next=B;
        B.next=C;
//        ArrayList<Integer> res=InvertedSequenceLinkedList.printListFromTailToHead(A);
//        for(Integer i:res){
//            System.out.println(i);
//        }

        System.out.println(InvertedSequenceLinkedList.ReverseList(A).val);

    }
}
