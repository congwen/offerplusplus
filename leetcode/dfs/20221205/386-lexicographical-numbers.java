import java.util.ArrayList;
import java.util.List;

class Solution386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, j = 1; i < n; i++) {
            ans.add(j);
            if (j * 10 <= n) {
                j *= 10;
            } else {
                while (j % 10 == 9 || j + 1 > n) j /= 10;
                j++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution386 s =new Solution386();
        s.lexicalOrder(19);
    }
}
 