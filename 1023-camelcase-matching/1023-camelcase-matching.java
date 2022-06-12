class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans=new ArrayList<>();
        
        for(String q:queries){
            ans.add(isMatch(q, pattern));
        }
        return ans;
    }
    private boolean isMatch(String q, String pattern){
        int i=0;
        for(char c:q.toCharArray()){
            if(i<pattern.length() && c==pattern.charAt(i)) i++;
            else if(c<'a') return false;
        }
        return i==pattern.length();
    }
}