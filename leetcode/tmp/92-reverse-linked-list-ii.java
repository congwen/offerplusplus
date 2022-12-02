class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head ==null || left < 0 || right < 0 || right < left) return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode start=dummy,end=dummy; //指向要反转的开始和结束的节点
        ListNode spre=null,enext=null;//开始节点pre,结束节点的next
        int idx=1;
        while(idx <= left){
            if(start==null) return dummy.next;
            idx++;
            spre=start;//记录pre
            start=start.next;
            end=end.next;
        }
       
        while(idx <=right){
            if(end==null) return dummy.next;
            idx++;
            end=end.next;
        }
        enext=end.next;//记录next
        end.next=null;//断开链表
        ListNode node = reverseList(start);//反转链表
        spre.next=node;//拼接链表
        start.next=enext;
        return dummy.next;
        
    }
    public ListNode reverseList(ListNode s){
        ListNode pre =null ,cur=s;
        while(cur!=null){
            ListNode tmp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;
        }
        return pre;
    }
}