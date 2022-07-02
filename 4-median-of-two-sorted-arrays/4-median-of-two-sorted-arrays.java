class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length, len2=nums2.length, len=len1+len2;
        if(len2<len1) return findMedianSortedArrays(nums2, nums1);
        
        if(len1==0) return ((double)nums2[(len2-1)/2] +(double)nums2[len2/2])/2;
            
        int l1=0, r1=len1, l2=0, r2=len2;
        while(l1<=r1){
            int m1=(l1+r1)/2;
            int m2=(len+1)/2-m1;
            
            double left1= (m1==0)? Integer.MIN_VALUE : nums1[m1-1];
            double left2= (m2==0)? Integer.MIN_VALUE : nums2[m2-1];
            double right1= (m1==len1)? Integer.MAX_VALUE : nums1[m1];
            double right2= (m2==len2)? Integer.MAX_VALUE : nums2[m2];
            
            if(left1>right2) r1=m1-1;
            else if(left2>right1) l1=m1+1;
            else{
                if(len%2==0) return (Math.max(left1, left2)+Math.min(right1, right2))/2;
                return Math.max(left1, left2);
            }
        }
        return -1;
        /* 7:8
            l1 r1
        [2, 4, 6, 7, 10]
                    l2  r2
        [1, 3, 5, 8, 9, 11, 12, 13, 14]
        
        */
    }
}