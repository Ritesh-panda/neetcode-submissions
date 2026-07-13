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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current1=list1;
        ListNode current2=list2;
        if(list1==null && list2==null) return null;
        ArrayList<Integer> arr1= new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        while(current1!=null){
            arr1.add(current1.val);
            current1=current1.next;
        }
        while(current2!=null){
            arr2.add(current2.val);
            current2=current2.next;
        }
        ArrayList<Integer> merged=new ArrayList<>(arr1);
        merged.addAll(arr2);
        merged.sort(Comparator.naturalOrder());
        ListNode head=new ListNode(merged.get(0));
        ListNode current=head;
        for(int i=1;i<merged.size();i++){
         
         ListNode newnode=new ListNode(merged.get(i));
         current.next=newnode;
         current=current.next;
         
         
        }
        return head;
    }
}