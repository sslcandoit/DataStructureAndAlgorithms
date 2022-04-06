class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len=cardPoints.length;
        if(len==k) return Arrays.stream(cardPoints).sum();
        
        int start=len-k;
        int ans=0;
        int win=0;
        for(int i=start; i<len+k; i++){
            win+=cardPoints[i%len];
            if(i>=len) win-=cardPoints[start+(i%len)]; 
            ans=Math.max(ans, win);
        }
        return ans;
    }
}