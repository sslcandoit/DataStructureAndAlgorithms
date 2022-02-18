class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0, -1);
        
        int preRemainder=0;
        for(int i=0; i<nums.length; i++){
            preRemainder=(preRemainder+nums[i])%k;
            
            Integer index=map.get(preRemainder);
            if(index !=null){
                if(i-index>=2) return true;
            }else map.put(preRemainder, i);
        }
        return false;
    }
}