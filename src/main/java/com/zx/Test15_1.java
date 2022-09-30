package com.zx;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author zx
 * @create 2022/9/22 20:43
 */
public class Test15_1 {
    static  Random random = new Random();
    public static void main(String[] args) {

        int[] list = getList(20);

        System.out.println("排序前" + toList(list));
        System.out.println("排序后" + toList(bullbleSort(list)));
        int[] list2 = getList(20);
        System.out.println("排序前" + toList(list2));
        quickSort(list2,0,list2.length-1);
        System.out.println("快排后"+ toList(list2));

    }
    public static int[] getList(int n){
        int[] ints = new int[n];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(100);
        }
        return ints;
    }
    public static List toList(int[] list){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : list) {
            result.add(i);
        }
        return result;
    }
    //冒泡排序
    public static int[] bullbleSort(int[] list){
        int temp = 0;
        for (int j = 0; j < list.length - 1; j++) {
            for (int i = 0; i < list.length - 1-j; i++) {
                if (list[i] > list[i + 1]) {
                    temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }
        }
        return list;
    }

    public static void changeItem(int[] list,int a , int b){
        int temp = 0;
        temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
    //快速排序
    public static void quickSort(int[] list,int a,int b){
        if (a < b ) {
            int per = list[a];
            int head = a;
            int tail = b;
            while (head < tail) {
                while (  head < tail && list[tail] >= per) tail--;
                if(head < tail) {
                    list[head++] = list[tail];
                }

                while ( head < tail && list[head] < per ) head++;
                if(head < tail) {
                    list[tail--] = list[head];
                }
            }
            list[head] = per;
            quickSort(list,a,head - 1);
            quickSort(list,head + 1,b);
        }
    }



}
