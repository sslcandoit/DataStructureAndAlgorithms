class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        String newPattern = "[a-z]*" + String.join("[a-z]*", pattern.split("")) + "[a-z]*";
        return Arrays.stream(queries).map(q -> q.matches(newPattern)).collect(Collectors.toList());
    }
        /*
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
    }    */
}
//return Arrays.stream(queries).map(q -> q.matches("[a-z]*" + String.join("[a-z]*", pattern.split("")) + "[a-z]*")).collect(Collectors.toList());