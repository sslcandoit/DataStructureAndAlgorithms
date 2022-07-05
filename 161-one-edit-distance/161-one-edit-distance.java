class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m=s.length(), n=t.length(), count=0;
        for(int i=0; i<Math.min(m, n); i++){
            if(s.charAt(i) !=t.charAt(i)){
                if(m==n) return s.substring(i+1).equals(t.substring(i+1));
                else if(m<n) return s.substring(i).equals(t.substring(i+1));
                else return t.substring(i).equals(s.substring(i+1));
            }
        }
        return Math.abs(m-n)==1;
    }
}
/*
"a"
"ac"

"a"
""

""
""
*/