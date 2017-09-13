package leetcode.algorithm;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class AddTwoNum {
    public static  ListNode addTwoNumbers(ListNode l1,
                                       ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode res_temp = result;
        int time = 0;
        int step = 0;
        while (l1 != null || l2 != null){
            int a = 0,b = 0;
            if(l1 != null)
                a = l1.val;
            if(l2 != null)
                b = l2.val;
            int temp = a + b + step;
            int index = temp % 10;
            step = temp / 10;
            res_temp.next = new ListNode(index);
            res_temp = res_temp.next;
            if(l1 != null && l1.next != null)
                l1 = l1.next;
            else
                l1 = null;
            if(l2 != null && l2.next != null)
                l2 = l2.next;
            else
                l2 = null;
            if(step > 0){
                res_temp.next = new ListNode(step);
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(0);
        ListNode l3 = addTwoNumbers(l1,l2);
        while(l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }


    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

