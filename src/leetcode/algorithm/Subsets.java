package leetcode.algorithm;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class Subsets {
    ArrayList<List<Integer>> subList = new
            ArrayList<List<Integer>>();
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] a = {4,4,4,1,4};
        int[] b = {};
        subsets.buildTree(a,b,-1);
        for (List l : subsets.subList) {
            for (Object i: l){
                System.out.print((int)i);
            }
            System.out.println();
        }
    }
//    public boolean equalsArrayList(List<Integer> a,
//                                   List<Integer> b){
//        if(a.size() == 0)
//            return true;
//        if(a.equals(b))
//            return false;
//        if (a.size() != b.size())
//            return false;
//        for (int i : a ) {
//
//        }
//
//    }
    public void buildTree(int[] array,int[] temp,int index){

        if(index == array.length-1){
            ArrayList<Integer> arrayList = new
                    ArrayList<Integer>();
            Arrays.sort(temp);
            for (int i : temp) {
                arrayList.add(i);
            }
            for(List l:subList){
                if(arrayList.equals(l))
                    return;
            }
           subList.add(arrayList);
           return ;
        }
        index ++;
        buildTree(array,temp,index);
        int[] _temp = Arrays.copyOf(temp,temp.length+1);
        _temp[temp.length] = array[index];
        buildTree(array,_temp,index);

    }
}
