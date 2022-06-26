class Solution {
    public boolean detectCapitalUse(String word) {
        int m=word.length();
        if(word.charAt(0)>='a' && word.charAt(0)<='z') return helper(word, 'a', 'z');
        else if(word.charAt(m-1)>='A' && word.charAt(m-1)<='Z') return helper(word, 'A', 'Z');
        return helper(word.substring(1), 'a', 'z');
    }
    private boolean helper(String s, char start, char end){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)<start || s.charAt(i)>end) return false;
        }
        return true;
    }
}