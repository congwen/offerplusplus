//https://leetcode.cn/problems/additive-number/description/
class Solution306 {
    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0, 0, 0, 0);
    }
    /*
     * num : 数字串
     * idx : 第几个数字
     * cnt : 数字的个数，一个有效的累加序列至少包含 3 个数
     * presum : 前两数之和
     * cur : 当前数字
     */
    public boolean dfs(String num,int idx,int cnt,long presum,long cur ){
        if(idx >= num.length())return cnt > 2;
        long curnum=0;
        for(int i =idx;i<num.length();i++){
            char c =num.charAt(i);
            // 剪枝1：不能做为前导0，但是它自己是可以单独做为0来使用的
            if(num.charAt(idx)=='0' && i > idx) return false;
            curnum =curnum * 10 + c-'0';
            if(cnt >=2){
                long sum =presum + cur;
                // 剪枝2：如果当前数比之前两数的和大了，说明不合适
                if(curnum > sum) return false;
                // 剪枝3：如果当前数比之前两数的和小了，说明还不够，可以继续添加新的字符进来
                if(curnum < sum ) continue;
            }
            if(dfs(num, i+1, cnt+1, cur, curnum)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String num="199100199";
        Solution306 s =new Solution306();
        System.out.println( s.isAdditiveNumber(num));
    }
}
