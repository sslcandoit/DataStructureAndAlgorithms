class Solution {
    public int trap(int[] height) {
        int m=height.length;
        int[] leftMax=new int[m], rightMax=new int[m];
        leftMax[0]=height[0];
        rightMax[m-1]=height[m-1];
        
        for(int i=1; i<m; i++) leftMax[i]=Math.max(leftMax[i-1], height[i]);
        
        for(int i=m-2; i>=0; i--) rightMax[i]=Math.max(rightMax[i+1], height[i]);
        
        int ans=0;
        for(int i=0; i<m; i++){
            ans+=Math.min(leftMax[i], rightMax[i])-height[i];
        }
        return ans;
    }
}