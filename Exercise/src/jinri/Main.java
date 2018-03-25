package jinri;

import java.util.*;

/**
 * Created by zuce wei on 2018/3/24.
 */
public class Main {
    static int cal(String str){
        Stack<Integer> stack=new Stack<>();
        Stack<Character> chs=new Stack<>();
        int tmp=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch!='6'){
                if(!chs.isEmpty()){
                    int fv=stack.pop();
                    char fch=chs.pop();
                    int v= sum(fch,fv,tmp);
                    stack.push(v);
                    chs.push(ch);
                    tmp=0;
                }else {
                    stack.push(tmp);
                    chs.push(ch);
                    tmp=0;
                }
            }else {
                tmp=tmp*10+ch-'0';
            }
        }
        if(!chs.isEmpty()){
            int fv=stack.pop();
            char fch=chs.pop();
            return sum(fch,fv,tmp);
        }
        return stack.pop();
    }

    static int num(String str){
        Stack<Integer> stack=new Stack<>();
        Stack<Character> chs=new Stack<>();
        int tmp=0;
        stack.push(0);
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch!='6'){
                if(ch=='*'){
                    chs.push(ch);
                    stack.push(tmp);
                }else if(!chs.isEmpty()&&chs.peek()=='*'){
                    int v=tmp*stack.pop();
                    chs.pop();
                    chs.push(ch);
                    stack.push(v);
                }else {
                    chs.push(ch);
                    stack.push(tmp);
                }
                tmp=0;
            }else {
                tmp=tmp*10+ch-'0';
            }
        }

        if(chs.peek()=='*'){
            chs.pop();
            int top=stack.pop();
            stack.push(tmp*top);
        }else {
            stack.push(tmp);
        }

        Stack<Integer> rs=new Stack<>();
        while (!stack.isEmpty()){
            rs.push(stack.pop());
        }

        stack=rs;
        stack.pop();
        while (!chs.isEmpty()){
            int f=stack.pop();
            int l=stack.pop();
            switch (chs.pop()){
                case '+':
                    stack.push(f+l);
                    break;
                default:
                    stack.push(l-f);
            }
        }

        return stack.pop();
    }

    static int sum(char fch,int fv,int tmp){
        int v=0;
        switch (fch){
            case '-':
                v=fv  -tmp;
                break;
            case '*':
                v=fv  * tmp;
                break;
            case '+':
                v=fv  + tmp;
                break;
        }
        return v;
    }

    List<String> output(int v){
        String str=new String(v+"");
        String ss[][]=new String[6][str.length()];

        List<String> list=new ArrayList<>();
        for(int i=0;i<6;i++){
            for(int k=0;k<str.length();k++){

            }
        }
        return null;
    }
    static String[] strings = new String[]{
            "666666...66...66...666666",
            "....6....6....6....6....6",
            "66666....6666666....66666",
            "66666....666666....666666",
            "6...66...666666....6....6",
            "666666....66666....666666",
            "666666....666666...666666",
            "66666....6....6....6....6",
            "666666...6666666...666666",
            "666666...666666....666666"
    };

    public static void display(int n) {
        String nString = String.valueOf(n);
        StringBuilder[] stringBuilders = new StringBuilder[5];
        for (int i = 0; i < 5; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        for (int i = 0; i < nString.length(); i++) {
            if (nString.charAt(i) == '-') {
                stringBuilders[0].append(".....");
                stringBuilders[1].append(".....");
                stringBuilders[2].append("66666");
                stringBuilders[3].append(".....");
                stringBuilders[4].append(".....");
            } else {
                stringBuilders[0].append(strings[nString.charAt(i)-'0'].substring(0, 5));
                stringBuilders[1].append(strings[nString.charAt(i)-'0'].substring(5, 10));
                stringBuilders[2].append(strings[nString.charAt(i)-'0'].substring(10, 15));
                stringBuilders[3].append(strings[nString.charAt(i)-'0'].substring(15, 20));
                stringBuilders[4].append(strings[nString.charAt(i)-'0'].substring(20, 25));
            }
            for (int j = 0; j < 5; j++) {
                stringBuilders[j].append("..");
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(stringBuilders[i].toString().substring(0, nString.length()*7-2));
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num=in.nextInt();
        for(int i=0;i<num;i++){
            String s=in.next();
            int val= Main.num(s);
            Main.display(val);
        }
//        System.out.println(" "+Main.num("-6+6*6+6"));
    }
}
