class Solution {
    public double angleClock(int hour, int minutes) {
        if(hour==12 && minutes==0) return 0.0;
        if(minutes==0) return Math.min(hour*30, 360-(hour*30));
        
        if(hour==12) hour=0;
        
        int before=Math.abs(hour*30-minutes*6);
        double diff=minutes*30/60.0;
        double after=0.0;
        if(hour*5>minutes) after=before+diff; //in case 6:05
        else after=Math.abs(before-diff);
        
        return Math.min(after, 360-after);
    }
}