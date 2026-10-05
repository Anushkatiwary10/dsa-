class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original=image[sr][sc];
        if(original==color){
            return image;
        }
        int m=image.length;
        int n=image[0].length;
        int[][] directions={
            {-1,0},{1,0},{0,-1},{0,1}
        };
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc]=color;
        while(!q.isEmpty()){
            int[] node=q.poll();
            int row=node[0];
            int col=node[1];
            for(int dir[]:directions){
                int nr=row+dir[0];
                int nc=col+dir[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==original){
                    image[nr][nc]=color;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return image;
    }
}