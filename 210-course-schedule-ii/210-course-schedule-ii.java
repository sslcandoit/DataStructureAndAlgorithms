class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree=new int[numCourses];
        List<Integer>[] graph=new List[numCourses];
        for(int[] p:prerequisites){
            int key=p[1];
            degree[p[0]]++;
            if(graph[key]==null) graph[key]=new ArrayList<>();
            graph[key].add(p[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(degree[i]==0) q.add(i);
        }
        int[] ans=new int[numCourses];
        int j=0;
        while(!q.isEmpty()){
            int v=q.poll();
            ans[j++]=v;
            if(graph[v] !=null){
                for(int w:graph[v]){
                    degree[w]--;
                    if(degree[w]==0) q.add(w);
                }
            }
        }
        for(int i=0; i<numCourses; i++){
            if(degree[i] !=0) return new int[]{};
        }
        return ans;
    }
    /*
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
    */
}