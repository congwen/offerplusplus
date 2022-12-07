/**
1) 要使最终结果最大化，需使分子最大化，分母最小化；
2) 由于每个数字都在[2, 1000]之间，每次相除运算必然导致结果变小；
3) 为使分子最大化，没有任何必要 让nums[0]除以某个数，直接让nums[0]做分子必然最优；
4) 为使分母最小化，应让nums[1 ... n-1]连续相除，没有任何必要 增加括号而改变运算顺序；

因此，最终结果 = nums[0] / (nums[1] / nums[2] / ... /nums[n-1])
 */
class Solution553 {
    public String optimalDivision(int[] nums) {
     int n = nums.length;
     if (n == 1) return String.valueOf(nums[0]);
     StringBuilder sb = new StringBuilder();
     sb.append(nums[0]);
     sb.append("/");
     if (n > 2) sb.append("(");
     for (int i = 1; i < n; i++) {
         sb.append(nums[i]);
         if (i < n-1) sb.append("/");
     }
     if (n > 2) sb.append(")");
     return sb.toString();
 }
}