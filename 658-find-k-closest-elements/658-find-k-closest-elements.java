class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=0;
        int r=arr.length-k;
        while(l<r){
            int m=l+(r-l)/2;
            if(x-arr[m] > arr[m+k]-x) l=m+1;
            else r=m;
        }
        
        List<Integer> ans=new ArrayList<>();
        int index=l;
        while(k!=0){
            ans.add(arr[index++]);
            k--;
        }
        return ans;
    }
}