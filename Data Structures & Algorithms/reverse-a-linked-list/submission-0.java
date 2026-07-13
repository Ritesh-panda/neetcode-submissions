




 



 
 
 

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode prev=null;
        ListNode current= head;
        ListNode next=current.next;
        while(current!=null){
         next=current.next;
        current.next=prev;
        prev=current;
        current=next;
        
        
        
        }
        while(current!=null){
            System.out.println(current.val);
            current=current.next;

        }
return prev;
    }
}
