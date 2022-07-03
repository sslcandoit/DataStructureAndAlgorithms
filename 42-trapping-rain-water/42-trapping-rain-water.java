class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1, leftMax=0, rightMax=0, ans=0;
        while(l<r){
            if(height[l]<height[r]){
                if(height[l]>leftMax) leftMax=height[l];
                else ans+=leftMax-height[l];
                l++;
            }else{
                if(height[r]>rightMax) rightMax=height[r];
                else ans+=rightMax-height[r];
                r--;
            }   
        }
        return ans;
        /*
        Stack<Integer> stack=new Stack<>();
        int m=height.length, ans=0;
        for(int i=0; i<m; i++){
            while(!stack.isEmpty() && height[i]>height[stack.peek()]){
                int floor=stack.pop();
                if(stack.isEmpty()) break;
                int w=i-stack.peek()-1;
                int h=Math.min(height[i], height[stack.peek()])-height[floor];
                ans+=w*h;
            }
            stack.push(i);
        }
        return ans;
        /*
        int m=height.length, ans=0;;
        int[] leftMax=new int[m], rightMax=new int[m];
        leftMax[0]=height[0];
        rightMax[m-1]=height[m-1];
        
        for(int i=1; i<m; i++) leftMax[i]=Math.max(leftMax[i-1], height[i]);
        for(int i=m-2; i>=0; i--) rightMax[i]=Math.max(rightMax[i+1], height[i]);
        for(int i=0; i<m; i++) ans+=Math.min(leftMax[i], rightMax[i])-height[i];
        return ans;                                                                     */
    }
}