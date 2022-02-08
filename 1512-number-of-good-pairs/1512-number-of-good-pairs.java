class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int ans=0;
        for(int e:map.values()){
            if(e>1) ans+=e*(e-1)/2;
        }
        return ans;
        /*
        int[] count=new int[101];
        int res=0;
        
        for(int num:nums){
            res+=count[num]++;
        }
        return res;
        */
    }
}