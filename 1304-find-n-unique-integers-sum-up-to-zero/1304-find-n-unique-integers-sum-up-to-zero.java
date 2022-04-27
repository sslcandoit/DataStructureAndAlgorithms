class Solution {
    public int[] sumZero(int n) {
        int[] ans=new int[n];
        
        int temp=n;
        for(int i=0; i<n/2; i++){
            ans[i]= -temp;
            ans[n-1-i]=temp;
            temp--;
        }
        return ans;
    }
}