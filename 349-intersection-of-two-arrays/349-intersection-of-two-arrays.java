class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int m1=nums1.length, m2=nums2.length;
        int[] a=(m1<m2)? nums1:nums2;
        int[] b=(m2>m1)? nums2:nums1;
        Arrays.sort(a);
        Set<Integer> set=new HashSet<>();
        for(int i=0; i<b.length; i++){
            if(binarySearch(a, b[i])) set.add(b[i]);
        }
        int[] ans=new int[set.size()];
        int i=0;
        for(int n:set) ans[i++]=n;
            
        return ans;
    }
    private boolean binarySearch(int[] nums, int target){
        int l=0; 
        int r=nums.length;
        while(l<r){
            int m=l+(r-l)/2;
            if(nums[m]==target) return true;
            else if(nums[m]>target) r=m;
            else l=m+1;
        }
        return false;
    }
}
/*
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set=new HashSet<>();
        int i=0, j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                set.add(nums1[i]);
                i++;
                j++;
            } 
            else if(nums1[i]>nums2[j]) j++;
            else if(nums1[i]<nums2[j]) i++;  
        }
        i=0;
        int[] ans=new int[set.size()];
        for(int n:set) ans[i++]=n;
        return ans;
        */