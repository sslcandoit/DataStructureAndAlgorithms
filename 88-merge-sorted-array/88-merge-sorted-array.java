class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l=m-1, r=n-1, i=nums1.length-1;
        while(l>=0 || r>=0){
            if(r>=0 && (l<0 || nums2[r]>=nums1[l])) nums1[i--]=nums2[r--];
            else if(l>=0) nums1[i--]=nums1[l--];
        }
    }
}