package niuke;

/**
 * Created by zuce wei on 2018/3/16.
 */
public class StringReplace {
    public static String replaceSpace(StringBuffer str) {
       int num=0;
       for(int i=0;i<str.length();i++){
           if(str.charAt(i)==' '){
               num++;
           }
       }
       int length=str.length()+2*num;
       char ch[]=new char[length];
       int index=0;
       int strIndex=0;
       while(strIndex<str.length()){
           if(str.charAt(strIndex)!=' '){
               ch[index]=str.charAt(strIndex);
           }else {
               ch[index]='%';
               index++;
               ch[index]='2';
               index++;
               ch[index]='0';
           }
           index++;
           strIndex++;
       }
       return new String(ch);
    }

    public static void main(String s[]){
        System.out.println(StringReplace.replaceSpace(new StringBuffer("We Are Happy")));
    }
}

