class Solution {
    public int minSteps(String s, String t) {
        int m=s.length();
        
        int[] count=new int[26];
        for(int i=0; i<m; i++){
            count[s.charAt(i)-'a']++;
        }
        
        int ans=0;
        for(int i=0; i<m; i++){
            int index=t.charAt(i)-'a';
            if(count[index]>0) count[index]--;
            else ans++;
        }
        return ans;
    }
}