class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs=s.split(" ");
        int n=pattern.length();
        if(n !=strs.length) return false;
        
        Map<Character, String> map=new HashMap<>();
        
        for(int i=0; i<n; i++){
            char c=pattern.charAt(i);
            String str=strs[i];
            
            if(map.containsKey(c) && !map.get(c).equals(str)) return false;
            else if(!map.containsKey(c) && map.containsValue(str)) return false;
            
            map.put(c, str);
        }
        return true;
    }
}