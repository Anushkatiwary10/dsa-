class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        int provinces=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,isConnected,n,visited);
                provinces++;
            }
        }
        return provinces;
    }
    void dfs(int node,int[][] isConnected,int n,boolean[] visited){
        visited[node]=true;
        for(int neighbor=0;neighbor<n;neighbor++){
            if(isConnected[node][neighbor]==1 && !visited[neighbor]){
                dfs(neighbor,isConnected,n,visited);
            }
        }
    }
}