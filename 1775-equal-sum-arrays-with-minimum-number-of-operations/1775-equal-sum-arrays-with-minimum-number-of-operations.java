class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        /*
        int len1=nums1.length, len2=nums2.length;
        if(len1*6<len2*1 || len2*6<len1*1) return -1;
        
        int sum1=Arrays.stream(nums1).sum(), sum2=Arrays.stream(nums2).sum();
        if(sum2>sum1) return minOperations(nums2, nums1);
        int[] cnt=new int[6];
        Arrays.stream(nums1).forEach(num->cnt[num-1]++);
        Arrays.stream(nums2).forEach(num->cnt[6-num]++);
        
        int i=5;
        int ans=0;
        while(sum1>sum2){
            while(cnt[i]==0) i--;
            sum1-=i;
            cnt[i]--;
            ans++;
        }
        return ans; */
        int len1=nums1.length, len2=nums2.length;
        if(len1*6<len2*1 || len2*6<len1*1) return -1;
        
        int sum1=Arrays.stream(nums1).sum(), sum2=Arrays.stream(nums2).sum();
        if(sum2>sum1) return minOperations(nums2, nums1);
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i=len1-1, j=0, ans=0;
        while(sum1>sum2){
            if(i<0 || (j<len2 && (6-nums2[j])>(nums1[i]-1))) sum2+=6-nums2[j++];
            else sum1-=nums1[i--]-1;
            ans++;
        }
        return ans;
    }
}