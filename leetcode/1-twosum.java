import java.util.HashMap;
import java.util.Map;
//https://leetcode.cn/problems/two-sum/
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        //使用hashmap来保存历史数据
        Map<Integer,Integer> map=new HashMap<>();
        for(int i =0;i<nums.length;i++){
            int tmp=target-nums[i];
            if(map.containsKey(tmp)){//历史数据中如果存在差值，则有解
                return new int[]{map.get(tmp),i};//返回结果
            }else{
                map.put(nums[i],i);//存入
            }
        }
        return new int[]{-1,-1};//无结果
    }
}