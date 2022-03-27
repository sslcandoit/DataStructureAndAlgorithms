class Solution {
    public String addBoldTag(String s, String[] words) {
        int n=s.length();
        boolean[] bold=new boolean[n];
   
        for(int i=0; i<n; i++){
            for(String w:words){
                int j=i+w.length();
                if(j<=n && s.substring(i, j).equals(w)){
                    int l=i;
                    while(l<j) bold[l++]=true;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<n; i++){
            if(!bold[i]) sb.append(s.charAt(i));
            else{
                int j=i;
                while(j<n && bold[j]) j++;
                sb.append("<b>").append(s.substring(i, j)).append("</b>");
                i=j-1;
            }
        }
        return sb.toString();
    }
    //   "aaabbcc"     ["a","b","c"]    "<b>aaabbcc</b>"    //"aaabbcc"  ["d"]
}