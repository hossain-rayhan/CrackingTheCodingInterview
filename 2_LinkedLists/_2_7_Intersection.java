/**
 *LeetCode- 160
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //Cracking the Coding Interview Chapter 2.7
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        
        int lA = 0, lB = 0;
        ListNode a = headA;
        ListNode b = headB;
        
        //go to the end and calculate the length of list A
        while(a.next != null){
            a = a.next;
            lA++;
        }
        
        //go to the end and calculate the length of list B
        while(b != null){
            b.next = b.next;
            lB++;
        }
        
        //if end of both of the lists are not same, don't intersect
        if(a != b){
            return null;
        }
        
        //move a and b to the head again
        a = headA;
        b = headB;
        
        if(lA > lB){
            for(int i = 0; i < lA-lB; i++){
                a = a.next;
            }
        }else{
            for(int i = 0; i < lB-lA; i++){
                b = b.next;
            }
        }
        
        //now both of a and b are of same length
        //move one step at a time, where they will meet thats the intersection
        while(a != b){
            a = a.next;
            b = b.next;
        }
        
        return a;
    }
}
