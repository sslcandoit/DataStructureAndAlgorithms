class CustomStack {
    Deque<Integer> deque;
    Stack<Integer> stack;
    int maxSize;
    public CustomStack(int maxSize) {
        this.deque=new ArrayDeque<>();
        this.stack=new Stack<>();
        this.maxSize=maxSize;
    }
    public void push(int x) {
        if(deque.size()+1<=maxSize) deque.addLast(x);
    }
    public int pop() {
        if(deque.size()==0) return -1;
        return deque.pollLast();
    }
    public void increment(int k, int val) {
        int len=Math.min(k, deque.size());
        for(int i=0; i<len; i++) stack.push(deque.pollFirst());
        for(int i=0; i<len; i++) deque.offerFirst(stack.pop()+val);
    }
    /*
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
    */
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */