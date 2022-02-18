class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count=new HashMap<>();
        Map<Integer, Integer> first_index=new HashMap<>();
        
        int degree=0;
        int min=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int num=nums[i];
            first_index.putIfAbsent(num, i);
            
            count.put(num, count.getOrDefault(num, 0)+1);
            
            if(count.get(num)>degree){
                degree=count.get(num);
                min=i-first_index.get(num)+1;
            }else if(count.get(num)==degree){
                min=Math.min(min, i-first_index.get(num)+1);
            }
        }
        return min;
    }
}