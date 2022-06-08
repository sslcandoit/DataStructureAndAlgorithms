class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int startH=Integer.parseInt(loginTime.substring(0,2));
        int startM=Integer.parseInt(loginTime.substring(3));
        int start=startH*60+startM;
        
        int endH=Integer.parseInt(logoutTime.substring(0,2));
        int endM=Integer.parseInt(logoutTime.substring(3));
        int end=endH*60+endM;
        
        if(end<start) end+=24*60;
        
        start=(start+14)/15;
        end=end/15;
        
        return Math.max(end-start, 0);
    }
}