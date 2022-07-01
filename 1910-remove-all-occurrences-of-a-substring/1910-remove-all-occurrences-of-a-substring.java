class Solution {
    public String removeOccurrences(String s, String part) {
        int n=part.length();
        while(s.indexOf(part) !=-1){
            int i=s.indexOf(part);
            s=s.substring(0, i)+s.substring(i+n);
        }
        return s;
    }
}