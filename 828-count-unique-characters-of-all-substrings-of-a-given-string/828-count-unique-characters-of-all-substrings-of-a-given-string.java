class Solution {
    public int uniqueLetterString(String s) {
        int len=s.length();
        
        int[][] index=new int[26][2];
        
        for(int i=0; i<26; i++) Arrays.fill(index[i], -1);
        
        int ans=0;
        
        for(int i=0; i<len; i++){
            int idx=s.charAt(i)-'A';
            
            ans=ans+(index[idx][1]-index[idx][0])*(i-index[idx][1]);
            index[idx][0]=index[idx][1];
            index[idx][1]=i;
        }
        for(int i=0; i<26; i++){
            ans=ans+(index[i][1]-index[i][0])*(len-index[i][1]);
        }
        return ans;
    }
}