//https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
class SordOffer03{
    public int findRepeatNumber(int[] nums) {
        //题意中已经说明数组中的元素范围在[0-nums.lengh-1]内，所以不会越界    
        int[] arr = new int[nums.length];
           for(int i = 0; i < nums.length; i++){
               arr[nums[i]]++;
               if(arr[nums[i]] > 1) return nums[i];
           }
           return -1;
       }
}