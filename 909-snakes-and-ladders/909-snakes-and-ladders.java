class Solution {
    public int snakesAndLadders(int[][] board) {
        int m=board.length;
        boolean[] visited=new boolean[m*m+1];
        visited[1]=true;
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(1);
        
        int moves=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                int cur=q.poll();
                for(int j=1; j<=6; j++){
                    int temp=cur+j;
                    if(temp<=m*m && !visited[temp]){
                        if(temp==m*m) return moves+1;
                        
                        visited[temp]=true;
                        
                        int row=m-1-(temp-1)/m;
                        int col= ((m-row)%2 !=0)? (temp-1)%m : m-1-(temp-1)%m;
                        
                        int num=board[row][col];
                        if(num==m*m) return moves+1;
                        else if(num==-1) q.offer(temp);
                        else q.offer(num);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}