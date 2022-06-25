import java.util.PriorityQueue;
import java.util.Random;


class Solution {
    
    private final static Random random = new Random(System.currentTimeMillis());
    
    /**
     * 使用快排
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        // 第 1 大的数，下标是 len - 1;
        // 第 2 大的数，下标是 len - 2;
        // ...
        // 第 k 大的数，下标是 len - k;
        int len = nums.length;
        int target = len - k;
        
        int left = 0;
        int right = len - 1;
        int res=0;
        while (left <=right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == target) {
                res= nums[pivotIndex]; 
                break;
            } else if (pivotIndex < target) {
                left = pivotIndex + 1; 
            } else {
                // pivotIndex > target
                right = pivotIndex - 1; 
            }
        }
        return res;
    }
    
    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);
        
        
        // all in nums[left + 1..le) <= pivot;
        // all in nums(ge..right] >= pivot;
        int pivot = nums[left];
        int le = left + 1;
        int ge = right;
        
        while (true) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }
            
            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }
            
            if (le >= ge) {
                break;
            }
            swap (nums, le, ge);
            le++;
            ge--;
        }
        
        swap(nums, left, ge);
        return ge;
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
