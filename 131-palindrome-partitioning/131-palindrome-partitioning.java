class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        helper(s, ans, new ArrayList<>(), 0);
        return ans;
    }
    private void helper(String s, List<List<String>> ans, List<String> temp, int start){
        if(start==s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
            
        for(int i=start+1; i<=s.length(); i++){
            if(isValid(s.substring(start, i))){
                temp.add(s.substring(start, i));
                helper(s, ans, temp, i);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean isValid(String temp){
        int l=0, r=temp.length()-1;
        while(l<r){
            if(temp.charAt(l) !=temp.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}