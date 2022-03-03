class Solution {
    private String[] buttons={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0) return ans;
        
        helper(digits, 0, "", ans);
        return ans;
    }
    private void helper(String str, int index, String s, List<String> ans){
        if(index==str.length()){
            ans.add(s);
            return;
        }
        String letters=buttons[str.charAt(index)-'0'];
        for(int i=0; i<letters.length(); i++){
            char c=letters.charAt(i);
            s+=c;
            helper(str, index+1, s, ans);
            s=s.substring(0, s.length()-1);
        }
    }
}