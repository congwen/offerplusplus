/** 
原数组：       [1       2       3       4]
左部分的乘积：   1       1      1*2    1*2*3
右部分的乘积： 2*3*4    3*4      4      1
结果：        1*2*3*4  1*3*4   1*2*4  1*2*3*1
从上面的图可以看出，当前位置的结果就是它左部分的乘积再乘以它右部分的乘积。因此需要进行两次遍历，第一次遍历用于求左部分的乘积，第二次遍历在求右部分的乘积的同时，再将最后的计算结果一起求出来。
*/
class Solution238 {
    public int[] productExceptSelf(int[] nums) {
         int[] res = new int[nums.length];
         int p = 1, q = 1;
         for (int i = 0; i < nums.length; i++) {
             res[i] = p;
             p *= nums[i];
         }
         for (int i = nums.length - 1; i > 0 ; i--) {
             q *= nums[i];
             res[i - 1] *= q;
         }
         return res;
     }
 
     public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4};
        
        int[] res=new Solution238().productExceptSelf(nums);
        for(int n : res){
            System.out.print(n+" ");
        }
        System.out.println();
     }
 
 }