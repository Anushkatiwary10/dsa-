class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, List<String>> graph = new HashMap<>();

        // How many ingredients are still needed for each recipe
        HashMap<String, Integer> indegree = new HashMap<>();

        // Build graph and indegree
        for (int i = 0; i < recipes.length; i++) {

            String recipe = recipes[i];

            indegree.put(recipe, ingredients.get(i).size());

            for (String ingredient : ingredients.get(i)) {

                graph.putIfAbsent(ingredient, new ArrayList<>());

                graph.get(ingredient).add(recipe);
            }
        }
        List<String> ans=new ArrayList<>();
        Queue<String> q=new LinkedList<>();
        for(String supply:supplies){
            q.add(supply);
        }
        while(!q.isEmpty()){
            String item=q.poll();
            if(!graph.containsKey(item)){
                continue;
            }
            for(String recipe:graph.get(item)){
                indegree.put(recipe,indegree.get(recipe)-1);
                if(indegree.get(recipe)==0){
                    ans.add(recipe);
                    q.add(recipe);
                }
            }
        }
        return ans;
    }
}