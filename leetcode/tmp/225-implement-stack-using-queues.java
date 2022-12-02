import java.util.LinkedList;
import java.util.Queue;

class Solution225 {
    private Queue<Integer> a;
    private Queue<Integer> b;
    public Solution225() {
        a=new LinkedList<>();
        b=new LinkedList<>();

    }
    
    public void push(int x) {
        //当a队列不为空时，把a队列里所有的元素转移到b队列
        while(!a.isEmpty()){
            b.offer(a.poll());
        }
        //此时a队列为空，把x放入a队列
        a.offer(x);
        //再把b队列的里元素转移到a队列，x在a队列第一个，实现后进先出
        while(!b.isEmpty()){
            a.offer(b.poll());
        }


    }
    
    public int pop() {
           return a.poll(); 
    }
    
    public int top() {
          return a.peek();  
    }
    
    public boolean empty() {
        return a.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */