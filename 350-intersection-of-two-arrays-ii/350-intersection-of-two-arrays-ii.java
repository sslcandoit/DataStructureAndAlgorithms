class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list=new ArrayList<>();
        for(int p1=0, p2=0; p1<nums1.length && p2<nums2.length; ){
            int n1=nums1[p1], n2=nums2[p2];
            if(n1==n2){
                list.add(n1);
                p1++;
                p2++;
            }else if(n1<n2) p1++;
            else p2++;
        }
        
        int[] ans=new int[list.size()];
        for(int i=0; i<list.size(); i++) ans[i]=list.get(i);
        return ans;
    }
}