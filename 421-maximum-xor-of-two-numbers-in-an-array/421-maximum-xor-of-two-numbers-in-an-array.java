class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask=0, ans=0;
        for(int i=31; i>=0; i--){
            mask=mask|(1<<i);
            
            Set<Integer> set=new HashSet<>();
            for(int num:nums) set.add(num&mask);
            
            int temp=ans|(1<<i);
            for(int n:set){
                if(set.contains(temp^n)){
                    ans=temp;
                    break;
                }
            }
        }
        return ans;
    }
}