class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
    
        Map<Integer, Integer> map=new HashMap<>();
        for(int num:nums) map.put(num, map.getOrDefault(num, 0)+1);
        
        List<Integer>[] bucket=new List[n+1];
        for(Map.Entry<Integer, Integer> e:map.entrySet()){
            if(bucket[e.getValue()]==null) bucket[e.getValue()]=new ArrayList<>();
            bucket[e.getValue()].add(e.getKey());
        } 
        
        List<Integer> ans=new ArrayList<>();
        for(int i=n; i>=0; i--){
            if(bucket[i]==null) continue;
            ans.addAll(bucket[i]);
            if(ans.size()==k) break;
        }
        
        int[] res=new int[ans.size()];
        for(int i=0; i<ans.size(); i++) res[i]=ans.get(i);
        
        return res;
    }
}