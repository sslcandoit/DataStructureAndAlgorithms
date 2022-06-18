class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> ans=new ArrayList<>();
        Map<String, String> map=new HashMap<>();
        map.put("0", "0");
        map.put("1", "1");
        map.put("8", "8");
        map.put("6", "9");
        map.put("9", "6");
        if(n%2==0) helper(map, ans, "", n);
        else{
            helper(map, ans, "0", n-1);
            helper(map, ans, "8", n-1);
            helper(map, ans, "1", n-1);
        }
        return ans;//n: 3  ans: ["101","609","808","906","181","689","888","986","111","619","818","916"]
    }
    private void helper(Map<String, String> map, List<String> ans, String cur, int remain){
        if(remain==0){
            ans.add(cur);
            return;
        } 
        
        for(String key:map.keySet()){
            if(remain==2 && key=="0") continue;
            helper(map, ans, key+cur+map.get(key), remain-2);
        }
    }
}