class Solution {
    public int strStr(String haystack, String needle) {
        int len=needle.length();
        if(needle==null || needle.length()==0) return 0;
        if(!haystack.contains(needle)) return -1;
        
        for(int i=0; i+len<=haystack.length(); i++){
            if(haystack.substring(i, i+len).equals(needle)) return i;
        }
        return -1;
    }
}