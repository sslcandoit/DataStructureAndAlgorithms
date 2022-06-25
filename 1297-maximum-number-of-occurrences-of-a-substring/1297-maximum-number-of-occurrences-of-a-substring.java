class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map=new HashMap<>();
        int m=s.length(), max=0;
        
        for(int i=0; i+minSize-1<m; i++){
            String sub=s.substring(i, minSize+i);
            if(helper(sub)<=maxLetters){
                map.put(sub, map.getOrDefault(sub, 0)+1);
                max=Math.max(max, map.get(sub));
            }
        }
        return max;
    }
    private int helper(String sub){
        Set<Character> set=new HashSet<>();
        for(char c:sub.toCharArray()) set.add(c);
        return set.size();
    }
}