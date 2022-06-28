class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> setStart=new HashSet<>();
        for(String s:startWords) setStart.add(helper(s));
        
        int ans=0;
        for(String t:targetWords){
            int binary=helper(t);
            for(char c:t.toCharArray()){
                int temp=binary-(1<<(c-'a'));
                if(setStart.contains(temp)){
                    ans++;
                    break;
                } 
            }
        }
        return ans;
    }
    private int helper(String s){
        int ans=0;
        for(char c:s.toCharArray()) ans+=(1<<(c-'a'));
        return ans;
    }
}