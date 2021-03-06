package leetcode.algorithm;

/***
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

 example1:
 Input: [4,2,3]
 Output: True
 Explanation: You could modify the first 4 to 1 to get a non-decreasing array.

 example2:
 Input: [4,2,1]
 Output: False
 Explanation: You can't get a non-decreasing array by modify at most one element.

 //wrong direct:思考了 i ,i - 1 ,i + 1 , 多思考了i + 2，没有考虑到循环性
 */
public class NonDecreasingArray {

    public static void main(String[] args) {
        int[] nums = {4,2,1};
        int count = 0;
        int temp = 0;
        for(int i = 0; i < nums.length && count < 1; i++){
            if(i + 1 < nums.length && nums[i] > nums[i + 1]){
                count ++;
                if(i - 1 < 0 || nums[i + 1]>=nums[i - 1])nums[i] = nums[i+1];
                else nums[i +1] = nums[i];
            }
        }
        if(count > 1)
            System.out.println(false);
        else
            System.out.println(true);
    }
}


