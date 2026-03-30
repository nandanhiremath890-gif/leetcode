class Solution {
    public ListNode partition(ListNode head, int x) {
        // Dummy nodes for two lists
        ListNode smallDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);
        
        ListNode small = smallDummy;
        ListNode greater = greaterDummy;
        
        // Traverse original list
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        
        // Important: avoid cycle
        greater.next = null;
        
        // Connect two lists
        small.next = greaterDummy.next;
        
        return smallDummy.next;
    }
}