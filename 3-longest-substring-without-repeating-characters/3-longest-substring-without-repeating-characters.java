class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int len=s.length();
        if(len==0) return 0;
        if(len==1) return 1;
        
        Map<Character, Integer> map=new HashMap<>();
        int max=1;
        int left=0;
        for(int i=0; i<len; i++){
            char c=s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, i);
            }else{
                left=Math.max(map.get(c)+1, left);
                map.put(c, i);
            }
            max=Math.max(max, i-left+1);
        }
        return max;
    }
}