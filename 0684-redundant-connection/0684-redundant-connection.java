class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            int[] visited = new int[n + 1];
            if(dfs(u, v, visited, list)){
                return edge;
            }
            list.get(u).add(v);
            list.get(v).add(u);
        }
        return new int[]{};
    }
    public boolean dfs(int node, int target,
                       int[] visited,
                       ArrayList<ArrayList<Integer>> list){

        if(node == target){
            return true;
        }

        visited[node] = 1;

        for(int neighbor : list.get(node)){

            if(visited[neighbor] == 0){

                if(dfs(neighbor, target, visited, list)){
                    return true;
                }
            }
        }

        return false;
    }
}