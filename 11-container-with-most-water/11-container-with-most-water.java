class Solution {
    public int maxArea(int[] height) {
        int ans=Integer.MIN_VALUE;
        int l=0, r=height.length-1;
        while(l<r){
            int area=(r-l)*Math.min(height[l], height[r]);
            ans=Math.max(ans, area);
            if(height[l]<height[r]) l++;
            else r--;
        }
        return ans;
    }
}