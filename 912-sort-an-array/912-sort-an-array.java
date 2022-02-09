class Solution {
    public int[] sortArray(int[] nums) {
        radixSort(nums);
        //shellSort(nums);
        return nums;
    }
    public void radixSort(int[] nums){
        int mostDigits=(Math.abs(nums[0])+"").length();
        for(int i=0, x=1; i<mostDigits; i++, x*=10){
            Map<Integer, List<Integer>> map=new HashMap<>();
            for(int num:nums){
                int len=(Math.abs(num)+"").length();
                if(len>mostDigits) mostDigits=len;
                
                int digit=num/x%10;
                if(!map.containsKey(digit)) map.put(digit, new ArrayList<>());
                map.get(digit).add(num);
            }
            int j=0;
            for(int index=-9; index<=9; index++){
                if(map.containsKey(index)){
                    for(int n:map.get(index)) nums[j++]=n;
                }
            }
        }
    }
    public void shellSort(int[] nums){
        int len=nums.length, h=len/2;
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
        }
    }
}