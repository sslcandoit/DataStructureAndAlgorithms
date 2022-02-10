class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int m=horizontalCuts.length;
        int n=verticalCuts.length;
        
        long maxH=Math.max(horizontalCuts[0], h-horizontalCuts[m-1]);
        for(int i=1; i<m; i++){
            maxH=Math.max(horizontalCuts[i]-horizontalCuts[i-1], maxH);
        }
        long maxV=Math.max(verticalCuts[0], w-verticalCuts[n-1]);
        for(int j=1; j<n; j++){
            maxV=Math.max(verticalCuts[j]-verticalCuts[j-1], maxV);
        }
        return (int)((maxH*maxV)%1000000007);
    }
}