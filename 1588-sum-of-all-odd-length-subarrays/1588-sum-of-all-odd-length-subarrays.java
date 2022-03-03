class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length;
        int sum=0;
        for(int i=0; i<n; i++){
            int count=(n-i)*(i+1);
            
            if(count%2==0) sum+=(count/2)*arr[i];
            else sum+=(count/2+1)*arr[i];
        }
        return sum;
    }
}