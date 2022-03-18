class Solution {
    Map<String, List<Integer>> map=new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        if(this.map.containsKey(expression)) return this.map.get(expression);
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0; i<expression.length(); i++){
            char c=expression.charAt(i);
            if(c=='+' || c=='-' || c=='*'){
                List<Integer> left=diffWaysToCompute(expression.substring(0, i));
                List<Integer> right=diffWaysToCompute(expression.substring(i+1));
                for(int l:left){
                    for(int r:right){
                        if(c=='+') ans.add(l+r);
                        else if(c=='-') ans.add(l-r);
                        else ans.add(l*r);
                    }
                }
            }
        }
        if(ans.size()==0) ans.add(Integer.parseInt(expression));
        this.map.put(expression, ans);
        return ans;
    }
}