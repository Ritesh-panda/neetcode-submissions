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
    public boolean hasCycle(ListNode head) {
        ListNode current=head;
        Set<Integer> set=new HashSet<>();
        if (current==null)return false;
        while(current.next!=null){
            if(set.contains(current.val)) return true;
            set.add(current.val);
            current=current.next;
        }
            
            

        
    return false;
    }
}
