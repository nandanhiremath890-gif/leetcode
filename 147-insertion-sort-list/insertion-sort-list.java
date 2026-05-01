class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode(0); // sorted list
        
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next; // store next node
            
            // Find correct position
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }
            
            // Insert current between prev and prev.next
            current.next = prev.next;
            prev.next = current;
            
            current = next;
        }
        
        return dummy.next;
    }
}