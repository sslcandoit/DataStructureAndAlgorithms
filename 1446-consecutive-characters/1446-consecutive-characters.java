class Solution {
    public int maxPower(String s) {
        int ans=1, n=s.length();
        for(int i=1, count=1; i<n; i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
                if(count>ans) ans=count;
            }else count=1;
        }
        return ans;
    }
}