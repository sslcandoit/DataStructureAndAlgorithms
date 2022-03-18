class Solution {
    int count;
    public int countArrangement(int n) {
        if(n==1) return 1;
        this.count=0;
        boolean[] visited=new boolean[n+1];
        helper(1,visited);
        return this.count;
    }
    private void helper(int i, boolean[] visited){
        if(i==visited.length){
            this.count++;
            return;
        } 
        for(int j=1; j<visited.length; j++){
            if(!visited[j] && (j%i==0 || i%j==0)){
                visited[j]=true;
                helper(i+1, visited);
                visited[j]=false;
            }
        }
    }
}