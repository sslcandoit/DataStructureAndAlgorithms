class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1=0, ele2=0, count1=0, count2=0;
        
        for(int num:nums){
            if(num==ele1 && count1>0) count1++;
            else if(num==ele2 && count2>0) count2++;
            else if(count1==0){
                ele1=num;
                count1=1;
            }else if(count2==0){
                ele2=num;
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        int cnt1=0, cnt2=0;
        for(int num:nums){
            if(num==ele1) cnt1++;
            else if(num==ele2) cnt2++;
        }
        List<Integer> ans=new ArrayList<>();
        if(cnt1> nums.length/3) ans.add(ele1);
        if(cnt2> nums.length/3) ans.add(ele2);
        
        return ans;
    }
}