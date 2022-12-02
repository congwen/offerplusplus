class Solution96{
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (n == 0) {
            return 0;
        }
        // 长度为 1 到 n
        for (int len = 1; len <= n; len++) {
            // 将不同的数字作为根节点，只需要考虑到 len
            for (int root = 1; root <= len; root++) {
                int left = root - 1; // 左子树的长度
                int right = len - root; // 右子树的长度
                dp[len] += dp[left] * dp[right];
            }
        }
        return dp[n];
    }
    
}