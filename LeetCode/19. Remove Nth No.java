/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 1;
        int j = 1; 
        ListNode dum = new ListNode(0);
        dum.next = head; 
        ListNode current = dum;  
        ListNode nth = dum; 
      
        while(current.next != null ){
            if( j - i   == n ){
                nth = nth.next; 
                i++; 
            }
            j++; 
            current = current.next; 

        }
      
           nth.next = nth.next.next; 
        
        
 return dum.next;  }
}
