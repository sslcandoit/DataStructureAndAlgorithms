class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        for(int[] c:connections){
            graph.get(c[0]).add(c[1]);
            graph.get(c[1]).add(-c[0]);
        }
        
        boolean[] visited=new boolean[n];
        int change=0;
        
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        
        while(!q.isEmpty()){
            int from=Math.abs(q.poll());
            visited[from]=true;
            
            for(int to:graph.get(from)){
                if(visited[Math.abs(to)]) continue;
                if(to>0) change++;
                q.add(to);
            }
        }
        return change;
    }
}