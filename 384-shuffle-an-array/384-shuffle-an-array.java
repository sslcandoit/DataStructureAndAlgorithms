class Solution {
    int[] original;
    Random rd;
    public Solution(int[] nums) {
        this.original=nums;
        this.rd=new Random();
    }
    
    public int[] reset() {
        return this.original;
    }
    
    public int[] shuffle() {
        if(original.length<=1) return original;
        int[] copy=original.clone();
        for(int i=1; i<copy.length; i++){
            int j=rd.nextInt(i+1);
            //i=1 -> j:0/1
            //i=2 -> j:0/1/2
            swap(copy, i, j);
        }
        return copy;
    }
    private void swap(int[] copy, int i, int j){
        int a=copy[i];
        copy[i]=copy[j];
        copy[j]=a;
    }
}
/*
To generate one sequence, 
there are n ways of generating the first number, 
      n - 1 ways of generating the second number, 
      n - 2 ways of generating the third number, ..., 
           1 way of generating the last number. 
Propability for any particular sequence is (1/n) * (1/(n - 1)) * (1/(n - 2)) * ... * 1/1 = 1/n!.
*/
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */