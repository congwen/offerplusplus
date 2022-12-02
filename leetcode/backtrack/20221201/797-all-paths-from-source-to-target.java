import java.util.ArrayList;
import java.util.List;

class Solution797 {
    int[][] g;
    int n;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g = graph; 
        n = g.length;
        cur.add(0);
        dfs(0);
        return ans;
    }
    void dfs(int u) {
        if (u == n - 1) {
            ans.add(new ArrayList<>(cur));
            return ;
        }
        for (int next : g[u]) {
            cur.add(next);
            dfs(next);
            cur.remove(cur.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[][] graph =new int[][]{{4,3,1},{3,2,4},{3},{4},{}};
        Solution797 s =new Solution797();
        List<List<Integer>> ans =s.allPathsSourceTarget(graph);
        System.out.println(ans);
    }
}
 