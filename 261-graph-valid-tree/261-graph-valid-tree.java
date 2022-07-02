class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parent=new int[n];
        Arrays.fill(parent, -1);
        for(int i=0; i<edges.length; i++){
            int x=findParent(parent, edges[i][0]);
            int y=findParent(parent, edges[i][1]);
            
            if(x==y) return false;
            parent[x]=y;
        }
        return edges.length==n-1;
    }
    private int findParent(int[] parent, int son){
        if(parent[son]==-1) return son;
        return findParent(parent, parent[son]);
    }
}