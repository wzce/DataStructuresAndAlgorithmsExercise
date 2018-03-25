package leetcode;

/**
 * Created by zuce wei on 2018/3/15.
 */
public class AddBinary {
    public static String addBinary(String a, String b) {

        StringBuilder res=new StringBuilder("");

        int index=0;
        int av,bv,v;
        int carry=0;
        while(index<=a.length()-1 || index<=b.length()-1){
            if(index>b.length()-1){
                bv=0;
            }else{
                bv=b.charAt(b.length()-index-1)-'0';
            }

            if(index>a.length()-1){
                av=0;
            }else{
                av=a.charAt(a.length()-index-1)-'0';
            }
            v=(carry+av+bv)%2;
            carry=(av+bv+carry)/2;
            System.out.println("   bv:"+bv+"  av:"+av+" index： "+index+" 进位："+carry+"  当前值："+v);
            //char ch=((av+bv)%2)+'0';
            res.append(String.valueOf(v));
            index++;
        }//end while

        if(carry==1){
            res.append(String.valueOf((1)));
        }
        return res.reverse().toString();
    }

    public static void main(String args[]){
        System.out.println(AddBinary.addBinary("1","11"));
    }
}
