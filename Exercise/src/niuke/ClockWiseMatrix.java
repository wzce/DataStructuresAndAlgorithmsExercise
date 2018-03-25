package niuke;

import java.util.ArrayList;

/**
 * Created by zuce wei on 2018/3/17.
 * 题目描述
 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 ，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class ClockWiseMatrix {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int rowStart=0;//行号
        int rowEnd=matrix.length-1;
        int colStart=0;//列号
        int colEnd=matrix[0].length-1;

        int index=0;
        int i,j;
        i=j=0;
        ArrayList<Integer> list=new ArrayList<>();
        while(index<matrix.length*matrix[0].length){
            list.add(matrix[i][j]);
            System.out.print(" "+matrix[i][j]);

            if(i==rowStart && j<rowEnd){
                j++;
            }else if(j==colEnd && i<rowEnd){
                i++;
            }else if(i==rowEnd && j>colStart){
                j--;
            }else if(j==colStart && i>rowStart){
                i--;
            }


            if(i==rowStart && j==colEnd){//右上角,即将往下走，行号加1
                rowStart++;
            }

            if(i==rowEnd && j==colEnd){//右下角,即将往左，列号减去1
                colEnd--;
            }

            if(j==colStart && i==rowEnd){//左下角,则即将往上走，行号减去1
                rowEnd--;
            }

            if(j==colStart && i==rowStart){//左上角
                colStart++;
            }

            index++;
        }//end while

        return list;
    }

    public static void main(String a[]){
        int m[][]={{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        ClockWiseMatrix.printMatrix(m);
    }
}
