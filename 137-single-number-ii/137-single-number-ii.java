class Solution {
    public int singleNumber(int[] nums) {
        Set<Long> set=new HashSet<>();
        long sum=0;
        for(int n:nums){
            sum+=n;
            set.add((long)n);
        }
        long temp=0;
        for(Long n:set)  temp+=n;
        return (int)((3*temp-sum)/2);
    }
}