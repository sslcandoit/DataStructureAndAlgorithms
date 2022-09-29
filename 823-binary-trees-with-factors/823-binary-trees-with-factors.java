class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        
        Map<Integer, Long> map=new HashMap<>();
        
        long ans=0, mod=1000000007;
        
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], 1L);
            
            for(int j=0; j<i; j++){
                
                if(arr[i]%arr[j]==0 && map.containsKey(arr[i]/arr[j])){
                    
                    map.put(arr[i], map.get(arr[i])+( map.get(arr[j])*map.get(arr[i]/arr[j]) )%mod);
                }
            }
            ans= (ans+map.get(arr[i]))%mod;
        }
        return (int)ans;
    }
}
/*
[18,3,6,2] 12
2
3
6, 2*3, 3*2
18, 3 *6, 3 *2*3, 3 *3*2, 6 *3, 2*3 *3, 3*2 *3

*/