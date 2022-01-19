class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs={{0,1},{-1,0},{0,-1},{1,0}};
        int direction=0;
        int x=0, y=0;
        for(int i=0; i<instructions.length(); i++){
            if(instructions.charAt(i)=='L') direction=(direction+1)%4;
            else if(instructions.charAt(i)=='R') direction=(direction+3)%4;
            else{
                x+=dirs[direction][0];
                y+=dirs[direction][1];
            }
        }
        return (x==0 && y==0) || direction!=0;
    }
}