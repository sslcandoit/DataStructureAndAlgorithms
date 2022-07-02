class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph=new HashMap<>();
        for(int[] e:edges){
            graph.putIfAbsent(e[0], new ArrayList<>());
            graph.putIfAbsent(e[1], new ArrayList<>());
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visited=new boolean[n];
        if(hasCircle(graph, visited, 0, -1)) return false;
        
        for(int i=0; i<n; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
    private boolean hasCircle(Map<Integer, List<Integer>> graph, boolean[] visited, int cur, int parent){
        visited[cur]=true;
        if(graph.containsKey(cur)){
            for(int n : graph.get(cur)){
                if((visited[n] && parent !=n)||(!visited[n] && hasCircle(graph, visited, n, cur))) return true;
            }
        }
        return false;
    }
    /*
    public boolean validTree(int n, int[][] edges) {
        int[] parent=new int[n];
        Arrays.fill(parent, -1);
        for(int i=0; i<edges.length; i++){
            int x=findParent(parent, edges[i][0]), y=findParent(parent, edges[i][1]);
            if(x==y) return false;
            parent[x]=y;
        }
        return edges.length==n-1;
    }
    private int findParent(int[] parent, int son){
        if(parent[son]==-1) return son;
        return findParent(parent, parent[son]);
    }*/
}
/*
4
[[0,1],[2,3]]

4
[[2,3],[1,2],[1,3]]

1
[]
*/