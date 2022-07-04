class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set=new HashSet<>();
        
        for(int i=0; i+k<=s.length() && set.size()<(1<<k); i++){
            String sub=s.substring(i, i+k);
            set.add(sub);
        }
        return set.size()==(1<<k);
    }
}
/*
1 0
11 00 10 01
*/