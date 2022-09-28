 
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
//  定义：
//     slow节点走的距离 = s
//     fast节点走的距离 = 2s
//     head -> 入口距离= a
//     环的长度=b
//     head -> 入口 -> 再回到入口的距离=a+b（走了一圈）
//     入口 -> 相遇节点距离= c
//     head -> 相遇节点距离s= a+c 
//     相遇节点 -> 入口距离= d

// 推出：
//     fast节点走的距离=a+b+c
//     环的长度= c+d

// 联合得到：
//     2(a+c)=a+c+d+c
//     2a+2c=a+2c+d
// 求得：
//     a=d（"head -> 入口的距离" 等于 "相遇节点 -> 入口的距离"）
class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if(null == head) return head;
        ListNode fast=head,slow=head;
        while(fast !=null && fast.next !=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                slow=head;
                while(slow !=fast){
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}