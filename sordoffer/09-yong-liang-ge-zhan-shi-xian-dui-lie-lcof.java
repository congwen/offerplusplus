class SordOffer09{
    Stack<Integer> stack1 =new Stack<>();
    Stack<Integer> stack2 =new Stack<>();
    public CQueue() {

    }
    
    public void appendTail(int value) {
            peek();
            offer(value);
    }
    
    public int deleteHead() {
        if(!stack1.isEmpty() || !stack2.isEmpty()){
            peek();
            return stack2.pop();
        }
        return -1;
     
    }
    /**
        入栈
     */
    public void offer(int val){
        stack1.push(val);
    }
    /**
        获取队首元素
     */
    public int peek(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }else{
             return stack2.peek();
        }
        return -1;
       
    }
}