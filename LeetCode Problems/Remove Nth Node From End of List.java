class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        
        ListNode first=dummy;
        ListNode second=dummy;
        for(int index=0;index<=n;index++)
        first=first.next;
        while(first!=null){
            first=first.next;
            second=second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
} 
