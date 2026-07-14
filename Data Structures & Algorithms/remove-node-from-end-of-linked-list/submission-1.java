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
       ArrayList<Integer> arr=new ArrayList<>();
       ListNode current=head;
       
       while(current!=null){
        arr.add(current.val);
        current=current.next;
       }
       arr.remove(arr.size()-n);
       if(arr.size()==0) return null;
       ListNode head1= new ListNode(arr.get(0));
       ListNode current1=head1;
       for(int i=1;i<arr.size();i++){
        ListNode node= new ListNode(arr.get(i));
        
        current1.next=node;
        current1=node;
        
        
         
        
        
        
       }
       return head1;
    }
}
