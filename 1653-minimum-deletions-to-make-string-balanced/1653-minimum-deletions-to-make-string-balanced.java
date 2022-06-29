class Solution {
    public int minimumDeletions(String s) {
        int cnt = 0;
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()=='b' && c=='a'){
                stack.pop();
                cnt++;
            }else stack.push(c);
        }
        return cnt;
        /*
        int a_right=s.chars().map(c -> c=='a'? 1:0).sum();
        int m=s.length(), b_left=0;
        int ans=a_right;
        for(int i=0; i<m; i++){
            if(s.charAt(i)=='a') a_right--;
            else{
                ans=Math.min(ans, a_right+b_left);
                b_left++;
            }
        }
        return Math.min(ans, b_left);
        /*
        int m= s.length();
	    int[] dp=new int[m+1];
        int bCount=0;
        for(int i=0; i<m; i++){
            if(s.charAt(i)=='a'){
                dp[i+1]=Math.min(dp[i]+1, bCount);
            }else{
                dp[i+1]=dp[i];
                bCount++;
            }
        }
        return dp[m];
        */
    }
}
/*
"aaaaa"
"bbbbb"
*/