class Solution {
    public int minStartValue(int[] nums) {
        int sum=1;
        int min=Integer.MAX_VALUE;
        for(int num:nums){
            sum+=num;
            min=Math.min(min, sum);
        }
        if(min>=1) return 1;
        return 1+(1-min);
    }
}