class Solution {
    int[] parent;
    int[] rank;
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        int components=n;
        for(int[] edge : connections){

            int u = edge[0];
            int v = edge[1];

            int rootU = find(u);
            int rootV = find(v);

            if(rootU == rootV){
                // Extra connection
                continue;
            }

            union(rootU, rootV);
            components--;
        }
        return components - 1;
    }
    public int find(int x){

        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }
    public void union(int rootA, int rootB){

        if(rank[rootA] < rank[rootB]){
            parent[rootA] = rootB;
        }
        else if(rank[rootA] > rank[rootB]){
            parent[rootB] = rootA;
        }
        else{
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
}