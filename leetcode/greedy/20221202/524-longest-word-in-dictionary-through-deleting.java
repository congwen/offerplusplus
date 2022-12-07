import java.util.Collections;
import java.util.List;

/**
我们可以先对 dictionary 根据题意进行自定义排序：

长度不同的字符串，按照字符串长度排倒序；
长度相同的，则按照字典序排升序。
然后我们只需要对 dictionary 进行顺序查找，找到的第一个符合条件的字符串即是答案

作者：宫水三叶
链接：https://leetcode.cn/problems/longest-word-in-dictionary-through-deleting/solutions/996367/gong-shui-san-xie-xiang-jie-pai-xu-shuan-qi20/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution524 {
    public String findLongestWord(String s, List<String> list) {
        Collections.sort(list, (a,b)->{
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });
        int n = s.length();
        for (String ss : list) {
            int m = ss.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (s.charAt(i) == ss.charAt(j)) j++;
                i++;
            }
            if (j == m) return ss;
        }
        return "";
    }
}
 