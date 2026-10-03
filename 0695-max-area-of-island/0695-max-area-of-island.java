class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int area=dfs(i,j,grid,m,n);
                    max=Math.max(max,area);
                }
            }
        }
        return max;
    }
    public int dfs(int row,int col,int[][] grid,int m,int n){
        if(row<0 || row>=m||col<0||col>=n||grid[row][col]==0){
            return 0;
        }
        grid[row][col]=0;
        int area=1;
        area+=dfs(row-1,col,grid,m,n);
        area+=dfs(row+1,col,grid,m,n);
        area+=dfs(row,col-1,grid,m,n);
        area+=dfs(row,col+1,grid,m,n);
        return area;
    }
}
