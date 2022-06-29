class Solution {
    public int maximumSum(int[] arr) {
        int m=arr.length;
        int oneDelete=0, noDelete=arr[0], ans=arr[0];
        
        for(int i=1; i<m; i++){
            oneDelete=Math.max(oneDelete+arr[i], noDelete);
            
            noDelete=Math.max(noDelete+arr[i], arr[i]);
            
            ans=Math.max(ans, Math.max(oneDelete, noDelete));
        }
        return ans;
    }
}