class Solution {
    private int[] visit;
    private Stack<Integer> order;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.order=new Stack<>();
        this.visit=new int[numCourses];
        List<Integer>[] graph=new List[numCourses];
        for(int[] p:prerequisites){
            int key=p[1];
            if(graph[key]==null) graph[key]=new ArrayList<>();
            graph[key].add(p[0]);
        }
        for(int i=0; i<numCourses; i++){
            if(visit[i]==0 && dfs(i, graph)) return new int[]{};
        }
        int[] ans=new int[order.size()];
        int i=0;
        while(!order.isEmpty()) ans[i++]=order.pop();
        return ans;
    }
    private boolean dfs(int i, List<Integer>[] graph){
        if(visit[i]==1) return true;
        
        visit[i]=1;
        if(graph[i] !=null){
            for(int v:graph[i]){
                if(visit[v] !=2){
                    if(dfs(v, graph)) return true;
                } 
            }
        }
        visit[i]=2;
        order.push(i);
        return false;
    }
}