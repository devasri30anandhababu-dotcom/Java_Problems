class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode second = dummy;

        while (true) {

            ListNode first = second;

    
            for (int i = 0; i < k && first != null; i++) {
                first = first.next;
            }

            if (first == null)
                break;

            ListNode curr = second.next;
            ListNode next = curr.next;

            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = second.next;
                second.next = next;
                next = curr.next;
            }

            second = curr;
        }

        return dummy.next;
    }
}
