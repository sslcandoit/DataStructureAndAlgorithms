class Solution {
    public int[] sortArray(int[] nums) {
        shellSort(nums);
        return nums;
    }
    public void shellSort(int[] nums){
        int len=nums.length;
        int h=len/2;
        while(h>=1){
            for(int i=h; i<len; i++){
                for(int j=i-h; j>=0; j-=h){
                    if(nums[j]>nums[j+h]){
                        int temp=nums[j];
                        nums[j]=nums[j+h];
                        nums[j+h]=temp;
                    }else break;
                }
            }
            h=h/2;
        }//[5,2,3,1,0,9,4,8,6,2,7]
    }
}