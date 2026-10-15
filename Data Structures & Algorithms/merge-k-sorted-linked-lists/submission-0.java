

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Add the head of each non-empty list
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();

            tail.next = node;
            tail = tail.next;

            // Add the next node from the same list
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }
}
