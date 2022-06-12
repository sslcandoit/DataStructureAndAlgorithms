class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n=nums1.length;;
        
        Map<Integer, Integer> map=new HashMap<>();
            
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int num=nums1[i]+nums2[j];
                map.put(num, map.getOrDefault(num, 0)+1);
            }
        }
        int ans=0;
        for(int k=0; k<n; k++){
            for(int l=0; l<n; l++){
                int num=nums3[k]+nums4[l];
                ans+= map.getOrDefault(-num, 0);
            }
        }
        return ans;
    }
}