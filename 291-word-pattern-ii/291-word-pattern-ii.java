class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map=new HashMap<>();
        Set<String> set=new HashSet<>();
        return helper(pattern, 0, s, 0, map, set);
    }
    private boolean helper(String p, int i_p, String s, int i_s, Map<Character, String> map, Set<String> set){
        if(i_p==p.length() && i_s==s.length()) return true;
        if(i_p==p.length() || i_s==s.length()) return false;
        
        char c=p.charAt(i_p);
        if(map.containsKey(c)){
            String exist=map.get(c);
            if(i_s+exist.length() > s.length()) return false;
            
            String cur=s.substring(i_s, i_s+exist.length());
            if(exist.equals(cur)) return helper(p, i_p+1, s, i_s+exist.length(), map, set);
            return false;
        }
        for(int i=i_s; i<s.length(); i++){
            String temp=s.substring(i_s, i+1);
            if(!set.contains(temp)){
                map.put(c, temp);
                set.add(temp);
                if(helper(p, i_p+1, s, i+1, map, set)) return true;
                map.remove(c);
                set.remove(temp);
            }
        }
        return false;
    }
}