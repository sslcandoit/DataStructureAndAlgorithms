class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastTravelDay=days[days.length-1];
        
        boolean[] isTravel=new boolean[lastTravelDay+1];
        for(int d:days) isTravel[d]=true;
        
        int[] dp=new int[lastTravelDay+1];
        
        for(int i=1; i<=lastTravelDay; i++){
            if(!isTravel[i]){
                dp[i]=dp[i-1];
                continue;
            } 
            dp[i]=dp[i-1]+costs[0];
            
            if(i-7>=0) dp[i]=Math.min(dp[i], dp[i-7]+costs[1]);
            else dp[i]=Math.min(dp[i], costs[1]);
            
            if(i-30>=0) dp[i]=Math.min(dp[i], dp[i-30]+costs[2]);
            else dp[i]=Math.min(dp[i], costs[2]);
        }
        return dp[lastTravelDay];
    }
}