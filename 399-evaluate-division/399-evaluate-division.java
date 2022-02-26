class Solution {
    private Map<String, Map<String, Double>> graph;
    private Set<String> visited;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        this.visited=new HashSet<>();
        double[] ans=new double[queries.size()];
        Arrays.fill(ans, -1.0);
        int i=0;
        buildGraph(equations, values);
        for(List<String> q:queries){
            String a=q.get(0), b=q.get(1);
            if(!graph.containsKey(a) || !graph.containsKey(b)) i++;
            else if(a.equals(b)) ans[i++]=1.0;
            else dfs(a, b, 1.0, ans, i++);
        }
        return ans;
    }
    /*
    [["x1","x2"],["x2","x3"],["x3","x4"],["x4","x5"]  
         3.0,         4.0,        5.0,       6.0
[["x1","x5"],["x5","x2"],["x2","x4"],["x2","x2"],["x2","x9"],["x9","x9"]]
    */
    private void dfs(String a, String b, double calc, double[] ans, int i){
        visited.add(a);
        if(graph.get(a).containsKey(b)) ans[i]=graph.get(a).get(b)*calc;
        else{
            Map<String, Double> map=graph.get(a);
            for(String key :map.keySet()){
                if(!visited.contains(key)) dfs(key, b, map.get(key)*calc, ans, i);
            }
        }
        visited.remove(a);
    }
    private void buildGraph(List<List<String>> equations, double[] values){
        this.graph=new HashMap<>();
        int i=0;
        for(List<String> e:equations){
            String a=e.get(0), b=e.get(1);
            if(!graph.containsKey(a)) graph.put(a, new HashMap<>());
            graph.get(a).put(b, values[i]);
            if(!graph.containsKey(b)) graph.put(b, new HashMap<>());
            graph.get(b).put(a, 1/values[i++]);
        }
    }
        
}