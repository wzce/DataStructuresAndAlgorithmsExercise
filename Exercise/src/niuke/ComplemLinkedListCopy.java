package niuke;

/**
 * Created by zuce wei on 2018/3/18.
 *
 *
 */

 class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class ComplemLinkedListCopy {
    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode node=new RandomListNode(pHead.label);
        if(pHead.next!=null){
            node.next=Clone(pHead.next);
        }

//        if(pHead.random){
//
//        }
        return null;
    }

}
