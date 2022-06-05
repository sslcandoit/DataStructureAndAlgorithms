class Solution {
    public boolean isBipartite(int[][] graph) {
        int len=graph.length;
        int[] color=new int[len];
        
        for(int i=0; i<len; i++){
            if(color[i] ==0){
                color[i]=1;
                
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                
                while(!q.isEmpty()){
                    int curV=q.poll();
                    int neibColor= color[curV]==1? 2:1;
                    
                    for(int neib:graph[curV]){
                        if(color[neib]==0){
                            color[neib]=neibColor;
                            q.add(neib);
                        }else if(color[neib] !=neibColor) return false;
                    }
                }
            }
        }
        return true;
    }
}