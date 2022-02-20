class CustomStack {
    int[] stack;
    int n;
    public CustomStack(int maxSize) {
        stack=new int[maxSize];
        this.n=0;
    }
    
    public void push(int x) {
        if(n<stack.length) stack[n++]=x;
    }
    
    public int pop() {
        if(n==0) return -1;
        int top=stack[n-1];
        n--;
        return top;
    }
    
    public void increment(int k, int val) {
        if(k<n){
            for(int i=0; i<k; i++) stack[i]+=val; 
        }else{
            for(int i=0; i<n; i++) stack[i]+=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */