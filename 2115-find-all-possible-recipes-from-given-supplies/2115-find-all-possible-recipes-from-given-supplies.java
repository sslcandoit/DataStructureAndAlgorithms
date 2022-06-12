class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n=recipes.length, m=supplies.length;;
        Map<String, Set<String>> map=new HashMap<>();
        Map<String, Integer> inDegree=new HashMap<>();
        
        for(int i=0; i<n; i++){
            String recipe=recipes[i];
            for(String ingred:ingredients.get(i)){
                if(!map.containsKey(ingred)) map.put(ingred, new HashSet<>());
                map.get(ingred).add(recipe);
            }
            inDegree.put(recipe, ingredients.get(i).size());
        }
        
        Queue<String> q=new LinkedList<>();
        for(int i=0; i<m; i++) q.add(supplies[i]);
        
        List<String> list=new ArrayList<>();
        while(!q.isEmpty()){
            String curSupply=q.poll();
            if(map.containsKey(curSupply)){
                for(String recipe:map.remove(curSupply)){
                    inDegree.put(recipe, inDegree.get(recipe)-1);
                    if(inDegree.get(recipe)==0){
                        inDegree.remove(recipe);
                        q.add(recipe);
                        list.add(recipe);
                    }
                }
            } 
        }
        return list;
    }
}