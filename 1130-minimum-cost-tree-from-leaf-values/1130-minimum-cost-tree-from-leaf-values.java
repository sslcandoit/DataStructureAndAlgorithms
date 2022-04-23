class Solution {
    public int mctFromLeafValues(int[] arr) {
        int len=arr.length;
        int[][] dp=new int[len][len];
        return dfs(arr, 0, len-1, dp);
    }
    private int dfs(int[] arr, int start, int end, int[][] dp){
        if(start==end) return 0;
        if(dp[start][end]>0) return dp[start][end];
        
        int ans=Integer.MAX_VALUE;
        for(int i=start; i<end; i++){
            int left=dfs(arr, start, i, dp);
            int right=dfs(arr, i+1, end, dp);
            int maxLeft=0, maxRight=0;
            for(int l=start; l<=i; l++) maxLeft=Math.max(maxLeft, arr[l]);
            for(int r=i+1; r<=end; r++) maxRight=Math.max(maxRight, arr[r]);
            ans=Math.min(ans, maxLeft*maxRight+left+right);
        }
        dp[start][end]=ans;
        return ans;
    }
     /*
        The problem can translated as following:
        Given an array A, choose two neighbors in the array a and b,
        we can remove the smaller one min(a,b) and the cost is a * b.
        What is the minimum cost to remove the whole array until only one left?

        To remove a number a, it needs a cost a * b, where b >= a.
        So a has to be removed by a bigger number.
        We want minimize this cost, so we need to minimize b.

        b has two candidates, the first bigger number on the left,
        the first bigger number on the right.

        The cost to remove a is a * min(left, right).
        */
        /*
        // time: O(n), space: O(n);
        int ans=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(Integer.MAX_VALUE);
        
        for(int a:arr){
            while(stack.peek()<=a){
                int mid=stack.pop();
                ans+=mid*Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while(stack.size()>2){
            ans+=stack.pop()* stack.peek();
        }
        return ans;
        */
}