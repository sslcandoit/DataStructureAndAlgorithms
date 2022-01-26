class Solution {
    private Map<String, Integer> memo=new HashMap<>();
    public int minKnightMoves(int x, int y) {
        return dfs(Math.abs(x), Math.abs(y));
    }
    private int dfs(int x, int y){
        String str=x+"+"+y;
        if(memo.containsKey(str)) return memo.get(str);
        
        if(x+y==0) return 0;
        else if(x+y==2) return 2;
        else{
            int l=dfs(Math.abs(x-1), Math.abs(y-2));
            int r=dfs(Math.abs(x-2), Math.abs(y-1));
            memo.put(str, Math.min(l, r)+1);
        }
        return memo.get(str);
    }
}