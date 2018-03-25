package niuke;

/**
 * Created by zuce wei on 2018/3/17.
 */

class Node<T extends Comparable<T>>{
    T val;
    Node next;
}



public class NodeExe {
    Node reverse(Node node){
        if(node==null){
            return node;
        }
        Node first=node;
        Node rem=node.next;
        first.next=null;
        Node sec;
        while(rem!=null){
            sec=rem;
            rem=rem.next;
            sec.next=first;
            first=sec;
        }
        return first;
    }

    public Node  solution(Node node1,Node node2){

        node2=reverse(node1);

        Node n2_head=node2;
        Node n1_pre=node1;
        Node n1_latter=n1_pre.next;
        //下面的则是归并过程
        while (node2!=null){
            if(n1_latter.val.compareTo(n2_head.val)>0){
                Node n=n2_head;
                n1_pre.next=n;
                n1_pre.next.next=n1_latter;
                n2_head=n2_head.next;

                n1_pre=n1_latter;
                n1_latter=n1_latter.next;
            }else {

            }
        }
        return null;
    }
}
