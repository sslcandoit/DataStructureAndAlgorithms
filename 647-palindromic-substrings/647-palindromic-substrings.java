class Solution {
    public int countSubstrings(String s) {
        int m=s.length();
        boolean[][] dp=new boolean[m][m];
        int ans=0;
        
        for(int i=0; i<m; i++, ans++) dp[i][i]=true;
        
        for(int i=0; i+1<m; i++){
            dp[i][i+1]=s.charAt(i)==s.charAt(i+1);
            ans+=(dp[i][i+1])? 1:0;
        }
        
        for(int len=3; len<=m; len++){
            for(int i=0, j=i+len-1; j<m; i++, j++){
                dp[i][j]=(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]);
                ans+=(dp[i][j])? 1:0;
            }
        }
        return ans;
    }
        /*
        int len=s.length();
        int ans=0;
        for(int i=0; i<len; i++){
            for(int j=0; i-j>=0 && i+j<len && (s.charAt(i-j)==s.charAt(i+j)); j++) ans++;
            for(int j=0; i-j>=0 && i+1+j<len && (s.charAt(i-j)==s.charAt(i+1+j)); j++) ans++;
        }
        return ans;
    }
        ****************************************************************************************
        int ans=0;
        for(int i=0; i<s.length(); i++){
            ans+=checkPalindromic(s, i, i);
            ans+=checkPalindromic(s, i, i+1);
        }
        return ans;
    }
    private int checkPalindromic(String s, int l, int r){
        int count=0;
        while(l>=0 && r<s.length()){
            if(s.charAt(l) !=s.charAt(r)) break;
            count++;
            l--;
            r++;
        }
        return count;
    }
    */
}