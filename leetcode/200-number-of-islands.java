class Solution {
    public int numIslands(char[][] grid) {
        if(null==grid || grid.length==0) return 0;
        int m=grid.length,n=grid[0].length;
        int num=0;
        //记录访问过的位置
        boolean[][] visited =new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //如果是0 或者已经访问过了，跳过
                if(grid[i][j]=='0' || visited[i][j]) continue;
                num++;//岛屿数量+1
                //把grid[i][j]位置的上、下、左、右标记已访问
                dfs(grid,visited,i,j);
            }
        }
        return num;
    }
    //把grid[i][j]位置的上、下、左、右标记已访问
    public void dfs(char[][] grid,boolean[][]visited,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j >=grid[0].length || grid[i][j]=='0' || visited[i][j]) return;
        visited[i][j]=true;
        dfs(grid,visited,i-1,j);
        dfs(grid,visited,i+1,j);
        dfs(grid,visited,i,j-1);
        dfs(grid,visited,i,j+1);
    
    }

}