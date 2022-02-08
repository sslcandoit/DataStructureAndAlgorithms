class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int count=0;
        for(Map.Entry<Integer, Integer> e:map.entrySet()){
            if(k>0 && map.containsKey(e.getKey()+k) || k==0 && e.getValue()>1) count++;
        }
        return count;
        /*
        Arrays.sort(nums);
        int count=0;
        for(int i=0; i<nums.length-1; i++){
            if(i !=0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<nums.length; j++){
                if(j !=i+1 && nums[j]==nums[j-1]) continue;
                if(Math.abs(nums[i]-nums[j])==k) count++;
            }
        }
        return count;
        */
    }
}