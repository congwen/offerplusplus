import java.util.Arrays;

//https://leetcode.cn/problems/array-partition-i/solutions/605303/jue-dui-neng-kan-dong-de-zheng-ming-fan-f7trz/
class Solution {
    public int arrayPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i += 2) ans += nums[i];
        return ans;
    }
}
 