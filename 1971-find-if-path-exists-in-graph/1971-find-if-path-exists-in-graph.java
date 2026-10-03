class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[n];
        q.offer(source);
        visited[source]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            if(node==destination){
                return true;
            }
            for(int neighbor:list.get(node)){
                if(!visited[neighbor]){
                    q.offer(neighbor);
                    visited[neighbor]=true;
                }
            }
        }
        return false;
    }
}