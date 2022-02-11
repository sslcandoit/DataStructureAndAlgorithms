class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        Arrays.stream(nums).forEach(num-> map.put(num, map.getOrDefault(num, 0)+1));
        
        
        return Arrays.stream(nums)
                     .boxed()
                     .sorted((a,b)->map.get(a)==map.get(b)? b-a:map.get(a)-map.get(b))
                     .mapToInt(n->n)
                     .toArray();
    }
}