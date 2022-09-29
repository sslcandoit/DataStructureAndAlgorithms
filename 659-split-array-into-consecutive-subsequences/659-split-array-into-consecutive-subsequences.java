class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> remain=new HashMap<>(), end=new HashMap<>();
        
        for(int num:nums) remain.put(num, remain.getOrDefault(num, 0)+1);
        
        for(int num:nums){
            
            if(remain.get(num)<=0) continue;
            
            remain.put(num, remain.get(num)-1);
            
            if(end.containsKey(num-1) && end.get(num-1)>0){
                end.put(num-1, end.get(num-1)-1);
                end.put(num, end.getOrDefault(num, 0)+1);
                
            }else if(remain.containsKey(num+1) && remain.get(num+1)>0 
                     && remain.containsKey(num+2) && remain.get(num+2)>0){
                remain.put(num+1, remain.get(num+1)-1);
                remain.put(num+2, remain.get(num+2)-1);
                end.put(num+2, end.getOrDefault(num+2, 0)+1);
                
            }else return false;  
        }
        return true;
    }
}