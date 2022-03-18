class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        this.ans=new ArrayList<>();
        helper(0,0,n,new StringBuilder());
        return this.ans;
    }
    private void helper(int l, int r, int max, StringBuilder sb){
        if(sb.length()==max*2){
            this.ans.add(sb.toString());
            return;
        }
        if(l<max){
            helper(l+1,r,max,sb.append('('));
            sb.deleteCharAt(sb.length()-1);
        }
        if(r<l){
            helper(l,r+1,max,sb.append(')'));
            sb.deleteCharAt(sb.length()-1);
        }
    }
}