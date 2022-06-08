class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        Stack<Integer> stack=new Stack<>();
        
        int i1=arr1.length-1, i2=arr2.length-1;
        int carry=0;
        while(i1>=0 || i2>=0 || carry !=0){
            if(i1>=0) carry+=arr1[i1--];
            if(i2>=0) carry+=arr2[i2--];
            
            stack.push(carry&1);//carry%2
            carry=-(carry>>1); //carry/2
        }
        while(!stack.isEmpty() && stack.peek() ==0) stack.pop();
        if(stack.isEmpty()) return new int[]{0};
        
        int[] ans=new int[stack.size()];
        for(int i=0; !stack.isEmpty(); i++) ans[i]=stack.pop();
        
        return ans;
    }
}
