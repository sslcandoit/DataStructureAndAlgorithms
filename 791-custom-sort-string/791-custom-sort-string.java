class Solution {
    public String customSortString(String order, String s) {
        int[] count=new int[26];
        for(int i=0; i<s.length(); i++) count[s.charAt(i)-'a']++;
        
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<order.length(); i++){
            char c=order.charAt(i);
            while(count[c-'a'] >0){
                sb.append(c);
                count[c-'a']--;
            } 
        }
        for(char c='a'; c<='z'; c++){
            while(count[c-'a']>0){
                sb.append(c);
                count[c-'a']--;
            }
        }
        return sb.toString();
    }
}