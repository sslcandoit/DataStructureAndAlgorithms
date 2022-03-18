class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n=strs.length;
        char[] first=strs[0].toCharArray();
        char[] last=strs[n-1].toCharArray();
        String ans="";
        for(int i=0; i<first.length; i++){
            if(last.length>i && first[i]==last[i]) ans+=first[i];
            else break;
        }
        return ans;
    }
}