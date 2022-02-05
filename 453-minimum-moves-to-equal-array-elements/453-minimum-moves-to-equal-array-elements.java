class Solution {
    public int minMoves(int[] nums) {
        /*
        minMoves=x, 
        final all elements become to:m
        everytime (n-1) to moves
        
        sum+x(n-1)=m*n
        m=min+x;
        
        sum+x*n-x=n*min+x*n
        sum-x=n*min
        x=sum-n*min;
        */
        int sum=Arrays.stream(nums).sum();
        int min=Arrays.stream(nums).min().getAsInt();
        int n=nums.length;
        return sum-min*n;
        /*
        Arrays.sort(nums);
        
        int ans=0;
        for(int i=nums.length-1; i>0; i--){
            ans+=nums[i]-nums[0];
        }
        return ans;
        */
    }
}