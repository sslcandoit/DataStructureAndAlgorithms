class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int diff=(Arrays.stream(aliceSizes).sum()-Arrays.stream(bobSizes).sum())/2;
        
        Set<Integer> set=new HashSet<>();
        for(int n:aliceSizes) set.add(n);
        
        int[] ans=new int[2];
        for(int n:bobSizes){
            if(set.contains(n+diff)){
                ans[1]=n;
                ans[0]=n+diff;
            }
        }
        return ans;
    }
}