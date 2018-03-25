package niuke;

/**
 * Created by zuce wei on 2018/3/17.
 */
public  class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }

    void show(){
        ListNode head=this;
        String s=" ";
        while (head!=null){
             s=s+" "+head.val;
             head=head.next;
        }

        System.out.println(s);
    }
}
