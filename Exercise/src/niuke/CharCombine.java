package niuke;

import java.util.*;

/**
 * Created by zuce wei on 2018/3/19.
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 输入描述:
 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class CharCombine {
    public static ArrayList<String> Permutation(String str) {
        if(str==null){
            return new ArrayList<>();
        }
        char[] ch=str.toCharArray();
        Arrays.sort(ch);//排序
        return formString(new String(ch));
    }

    static ArrayList<String> formString(String builder){

        ArrayList<String> list=new ArrayList<>();
        if(builder.length()==1){
            list.add(builder.toString());
            return list;
        }
        for(int i=0;i<builder.length();i++){
            char ch=builder.charAt(i);
            String head=""+ch;
            int kk=i+1;
            int num=0;
            for(;kk<builder.length();kk++){
                if(ch==builder.charAt(kk)){
                    head=head+ch;
                    num++;
                }else {
                    break;
                }
            }

            String subStr=builder.substring(0,i)+builder.substring(kk,builder.length());
            i=i+num;
            ArrayList<String> re=formString(subStr);
            if(re.size()==0){
                list.add(head);
            }else {
                for(String ss:re){
                    ss=head+ss;
                    list.add(ss);
                }
            }
        }
        return list;
    }

//非递归的方式实现
    public static ArrayList<String> combineChar(String s){
        if(s==null){
            return new ArrayList<>();
        }
        ArrayList<String> list=new ArrayList<>();
        char[] ch1=s.toCharArray();
        Arrays.sort(ch1);//排序
        list.add(new String(ch1));
        int i=0;
        while (i<s.length()){
            ArrayList<String> nextList=new ArrayList<>();
            for(String tem:list){
                nextList.add(tem);
                char ch[]=tem.toCharArray();
                //依次在每一位上的交换
                for(int j=i+1;j<ch.length;j++){
                    swap(ch,i,j);
                    String newStr=new String(ch);
                    if(!nextList.contains(newStr)){
                        nextList.add(newStr);
                    }
                    swap(ch,i,j);//生成之后交换回去
                }
            }
            i++;
            list.clear();
            list.addAll(nextList);
        }
        list.sort(String::compareTo);
        return list;
    }

    private static void swap(char ch[],int i,int j){
        char c=ch[i];
        ch[i]=ch[j];
        ch[j]=c;
    }

    public static void main(String args[]){
        String s="abc";
        List<String> list=CharCombine.combineChar(s);
        for(String ss:list){
            System.out.println(ss);
        }

    }
}
