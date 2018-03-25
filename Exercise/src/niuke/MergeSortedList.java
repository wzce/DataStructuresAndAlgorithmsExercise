package niuke;

/**
 * Created by zuce wei on 2018/3/17.
 */
public class MergeSortedList {
    //使用递归的方式
    public ListNode merge(ListNode list1,ListNode list2) {
        ListNode node;
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }

        if(list1.val>list2.val){
            node=list2;
            node.next=merge(list1,list2.next);
        }else{
            node=list1;
            node.next=merge(list1.next,list2);
        }
        return node;
    }

    public static ListNode notRecursiveMerge(ListNode list1,ListNode list2){
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        ListNode resNode;//存储结果的node
        ListNode head1=list1;
        ListNode head2=list2;
        if(head1.val>head2.val){
            resNode =head2;
            head2=head2.next;
        }else {
            resNode =head1;
            head1=head1.next;
        }
        ListNode head=resNode;//指向合并之后的头指针
        while (true){
            if(head1==null){
                resNode.next=head2;
                break;
            }else if(head2==null){
                resNode.next=head1;
                break;
            }

            if(head1.val>head2.val){
                resNode.next=head2;
                head2=head2.next;
            }else {
                resNode.next=head1;
                head1=head1.next;
            }
            resNode=resNode.next;
            resNode.next=null;
        }
        return head;
    }

    public static void main(String s[]){
        ListNode A=new ListNode(1);
        ListNode B=new ListNode(4);
        ListNode C=new ListNode(7);
        A.next=B;
        B.next=C;

        ListNode AA=new ListNode(2);
        ListNode BB=new ListNode(6);
        ListNode CC=new ListNode(6);
        AA.next=BB;
        BB.next=CC;

        MergeSortedList.notRecursiveMerge(A,AA).show();

    }
}
