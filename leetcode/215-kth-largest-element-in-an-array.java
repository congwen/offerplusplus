import java.util.PriorityQueue;
import java.util.Random;


class Solution215 {
    
    private final static Random random = new Random(System.currentTimeMillis());
    
    /**
     * 使用快排
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int left=0,right=nums.length-1;
        while(left <= right){
            int pivot=partition(nums,left,right);
            if((pivot+1) ==k){
                return nums[pivot];
            }else if((pivot+1) < k){
                left =pivot +1;
            }else{
                right =pivot ;
            }
        }
        return 0;
    }

    public int partition(int[] nums,int left,int right){
        int idx = random.nextInt(right - left + 1) + left;
        swap(nums, idx,left);
        int base = nums[left];
        // 快速排序，注意是从大到小，因为我们找的是第K 大
        while (left < right) {
            while (left < right && nums[right] <= base) {
                --right;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] >= base) {
                ++left;
            }
            nums[right] = nums[left];
        }
        nums[left] = base;
        return left;
    }

      private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    
    /**
     * 使用小顶堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue =new PriorityQueue<>();
        for(int n : nums){
            priorityQueue.offer(n);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }
}
