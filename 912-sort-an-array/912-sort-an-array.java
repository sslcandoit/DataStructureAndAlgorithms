class Solution {
    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length-1);
        //radixSort(nums);
        //shellSort(nums);
        return nums;
    }
    
    public void divide(int[] nums, int l, int r){
        if(l>=r) return;
        int mid=l+(r-l)/2;
        divide(nums, l, mid);
        divide(nums, mid+1, r);
        merge(nums, l, mid+1, r);
    }
    public void merge(int[] nums, int l, int mid, int r){//1245 23567
        int[] assist=new int[r-l+1];
        int p1=l, p2=mid;
        for(int i=0; i<assist.length; i++){
            if(nums[p2]<nums[p1]) assist[i]=nums[p2++];
            else assist[i]=nums[p1++];
            
            while(p1>=mid && p2<=r) assist[++i]=nums[p2++];
            while(p2>=r+1 && p1<mid) assist[++i]=nums[p1++];
        }
        for(int n:assist) nums[l++]=n;
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