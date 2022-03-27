class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans=0;
        int preIndex=0;
        for(int i=1; i<colors.length(); i++){
            char cur=colors.charAt(i);
            char pre=colors.charAt(preIndex);
            if(cur==pre){
                if(neededTime[i]<neededTime[preIndex]) ans+=neededTime[i];
                else{
                    ans+=neededTime[preIndex];
                    preIndex=i;
                } 
            }else preIndex=i;    
        }
        return ans;
    }
}