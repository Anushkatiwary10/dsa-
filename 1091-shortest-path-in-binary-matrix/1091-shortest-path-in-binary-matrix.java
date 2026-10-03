class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1||grid[n-1][n-1]==1){
            return -1;
        }
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,1});
        grid[0][0]=1;
        int directions[][]={  {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1},           {0, 1},
        {1, -1},  {1, 0},  {1, 1}};//for 8 directions

        while(!q.isEmpty()){
            int[] node=q.poll();
            int row=node[0];
            int col=node[1];
            int dist=node[2];
            if(row==n-1 && col==n-1){
                return dist;
            }
            for(int[] dir:directions){
                int nr=row+dir[0];
                int nc=col+dir[1];
                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0){
                    grid[nr][nc]=1;
                    q.add(new int[]{nr,nc,dist+1});
                }
            }
        }
        return -1;
    }
}