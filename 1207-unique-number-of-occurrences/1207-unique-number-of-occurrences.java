class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n=arr.length;
        Map<Integer, Integer> map=new HashMap<>();
        for(int num:arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        int[] count=new int[n+1];
        Arrays.fill(count, -2000);
        for(Map.Entry<Integer, Integer> e:map.entrySet()){
            if(count[e.getValue()] >-2000) return false;
            count[e.getValue()]=e.getKey();
        }
        return true;
    }
}