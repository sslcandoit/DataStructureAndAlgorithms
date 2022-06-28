class StockSpanner {
    Stack<int[]> stack;
    int n;
    public StockSpanner() {
        this.stack=new Stack<>();
        this.n=0;
    }
    
    public int next(int price) {
        n++;
        while(!this.stack.isEmpty() && stack.peek()[0]<=price) stack.pop();
        
        int ans=n-(stack.isEmpty()? 0:stack.peek()[1]);
        
        this.stack.push(new int[]{price, n});
        
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */