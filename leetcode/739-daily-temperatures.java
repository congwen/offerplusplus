import java.util.Stack;

class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res=new int[temperatures.length];
        Stack<Integer> stack =new Stack<>();
        for (int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int t=stack.pop();
                res[t]=i-t;
            }
            stack.push(i);
        }
        return res;
        
    }
    public static void main(String[] args) {
        int[] temperatures=new int[]{73,74,75,71,69,72,76,73};
        new Solution739().dailyTemperatures(temperatures);
    }
}