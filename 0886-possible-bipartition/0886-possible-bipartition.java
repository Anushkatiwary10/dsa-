class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color=new int[n+1];
        Arrays.fill(color,-1);
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge:dislikes){
            int u=edge[0];
            int v=edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(color[i]!=-1){
                continue;
            }
            q.offer(i);
            color[i]=0;
            while(!q.isEmpty()){
                int node=q.poll();
                for(int neighbor:list.get(node)){
                    if(color[neighbor]==-1){
                        color[neighbor]=1-color[node];
                        q.offer(neighbor);
                    }else if(color[neighbor]==color[node]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}