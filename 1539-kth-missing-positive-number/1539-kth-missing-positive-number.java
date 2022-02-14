class Solution {
    public int findKthPositive(int[] arr, int k) {
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
    }
}