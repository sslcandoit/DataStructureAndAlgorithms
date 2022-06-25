class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        for(int i=0; i+1<arr.length; i++){
            if(arr[i]>arr[i+1]) return i;
        }
        return 0;
        /*
        int l=0, r=arr.length-1;
        while(l<r){
            int m=l+(r-l)/2;
            if(arr[m]<arr[m+1]) l=m+1;
            else r=m;
        }
        return l; */
    }
    /* 
             /\
           /    \
          /      \
    */
}