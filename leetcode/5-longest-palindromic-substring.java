class Solution5{
    public String longestPalindrome1(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);

    }
    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //循环最后做了一次left--,right++计算，使left<0或者right>=s.length()跳出循环
        //所以左边界=left+1,右边界=right-1,当前回文串的长度=(right-1)-(left+1)+1=right-left-1
        return right - left - 1;
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() ==0) return "";
        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length() ; i++) {
            int l1 = expand(s, i, i);//回文中心点是一个字符，比如：bab
            int l2 = expand(s, i, i + 1);//回文中心点是两个字符，比如：baab
            int len = Math.max(l1, l2);//两种情况的最大长度
            if (len > maxLen) {
                start = i - (len - 1)/2;// i是中心点，(len - 1)/2是当前回文串左边的起始位置
                maxLen = len;//更新最大长度
            }
        }
        return s.substring(start, start + maxLen);//截取最长回文子串
    }

    public static void main(String[] args) {
        String s="babad";
        System.out.println(new Solution5().longestPalindrome2(s));
    }
}