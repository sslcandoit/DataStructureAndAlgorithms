class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map=new TreeMap<>();
        
        int r, l;
        for(l=0, r=0; r<nums.length; r++){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            
            if(map.lastKey()-map.firstKey()>limit){
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l])==0) map.remove(nums[l]);
                l++;
            }
        }
        return r-l;
    }
}