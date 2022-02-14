class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l=0;
        int r=arr.length-1;
        while(l<=r){
            int pivot=l+(r-l)/2;
            if(arr[pivot]-1-pivot<k) l=pivot+1;
            else r=pivot-1;
        }
        return l+k;
        /*
        int cur=1;
        int i=0;
        while(i<arr.length && k>0){
            if(arr[i]==cur) i++;
            else{
                k--;
                if(k==0) return cur;
            } 
            cur++;
        }
        while(k!=0){
            k--;
            cur++;
        } 
        return cur-1;
        */
    }
}