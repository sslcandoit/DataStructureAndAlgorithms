class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int n=nums.length, second=Integer.MIN_VALUE;
        
        for(int i=n-1; i>=0; i--){
            if(nums[i]<second) return true;
            while(!stack.isEmpty() && nums[i]>stack.peek()){
                second=stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
        }
    }
    /* top左边最小的为third，top右边比top小的数中最大的一个是second
                  j(top)
                 /     \
                /   k(second)
            i(third)                          
    */