class Solution {
    public boolean isPalindrome(int x) {
        String s=x+"";
        int l=0, r=s.length()-1;
        while(l<r){
            if(s.charAt(l++) !=s.charAt(r--)) return false;
        }
        return true;
    }
}