class Solution {
    private int[] visit;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.visit=new int[numCourses];
        List<Integer>[] graph=new List[numCourses];
        for(int[] p:prerequisites){
            int key=p[1];
            if(graph[key]==null) graph[key]=new ArrayList<>();
            graph[key].add(p[0]);
        }
        for(int i=0; i<numCourses; i++){
            if(visit[i]==0 && dfs(i, graph)) return false;
        }
        return true;
    }
    public boolean dfs(int i, List<Integer>[] graph){
        if(visit[i]==1) return true; //has circle
        visit[i]=1;//visiting
        if(graph[i] !=null){
            for(int v:graph[i]){
                if(visit[v] !=2){
                    if(dfs(v, graph)) return true;
                } 
            }
        }
        visit[i]=2;//visited
        return false;
    }
}