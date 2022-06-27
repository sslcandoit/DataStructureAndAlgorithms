class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        Queue<List<Integer>> q=new LinkedList<>();
        q.add(new ArrayList<>());
        
        List<List<Integer>> ans=new ArrayList<>();
        
        while(!q.isEmpty()){
            List<Integer> from=q.poll();
            if(from.size()==0) from.add(0);
            if(from.get(from.size()-1)==n-1){
                ans.add(from);
                continue;
            } 
            for(int to:graph[from.get(from.size()-1)]){
                from.add(to);
                q.add(new ArrayList<>(from));
                from.remove(from.size()-1);
            }
        }
        return ans;
    }
}