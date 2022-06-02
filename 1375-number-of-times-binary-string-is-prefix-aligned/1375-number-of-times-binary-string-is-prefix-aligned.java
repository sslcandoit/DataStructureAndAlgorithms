class Solution {
    public int numTimesAllBlue(int[] flips) {
        int n=flips.length;
        int[] binary = new int[n];
        int left=0;
        
        int ans=0;
        for(int i=0; i<n; i++){
            binary[flips[i]-1]=1;
            
            while(left<n && binary[left] !=0) left++;
            
            if(left>i) ans++;
        }
        return ans;
    }
}