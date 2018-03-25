package meituan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zuce wei on 2018/3/22.
 */
public class Main {
    int distance(String str1,String s2){
        int sum=0;
        for(int i=0;i<str1.length();i++){
            if(str1.length()-i>=s2.length()){
                for(int j=0;j<s2.length();j++){
                    if(s2.charAt(j)!=str1.charAt(j+i)){
                       sum++;
                    }
                }
            }
        }
        return sum;
    }

    String minNumber(char ch[]){
        Arrays.sort(ch);
        boolean in[]={false,false,false,false,false,false,false,false,false,false,false};
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<10;i++){
            map.put(i,0);
        }

        for(int i=0;i<ch.length;i++){
            in[(ch[i]-'0')]=true;
            if(map.containsKey((ch[i]-'0'))){
                int num=map.get(ch[i]-'0');
                map.remove(ch[i]-'0');
                map.put(ch[i]-'0',num+1);
            }else {
                map.put(ch[i]-'0',1);
            }
        }
        for (int i=0;i<10;i++){
            if (!in[i] && i!=0){
                return new String(i+"");
            }
        }
        //前面部分检测1-9位

        int minNum=map.get(1);
        int loc=1;
        for(int i=2;i<10;i++){
            if(map.get(i)<minNum){
                minNum=map.get(i);
                loc=i;
            }
        }
        if(!in[0]){
            return new String(""+loc+"0");
        }

        StringBuilder s=new StringBuilder("");
        for(int i=0;i<map.get(loc);i++){
            s.append(loc);
        }
        s.append(loc);
        return s.toString();
    }

    public static void main(String args[]){
//        Scanner scanner=new Scanner(System.in);
//        String str1=scanner.next();
////        String str2=scanner.next();
//        Main main=new Main();
//        System.out.println(main.minNumber(str1.toCharArray()));
        int b=0;
        int a=b++;
        System.out.println(a);
    }
}
