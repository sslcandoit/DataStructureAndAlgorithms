class MyCircularQueue {
    private int[] nums;
    private int front=0, rear=-1, len=0;
    
    public MyCircularQueue(int k) {
        this.nums=new int[k];
    }
    public boolean enQueue(int value) {
        if(!isFull()){
            rear=(rear+1)%nums.length;
            nums[rear]=value;
            len++;
            return true;
        } else return false;
    }
    
    public boolean deQueue() {
        if(!isEmpty()){
            front=(front+1)%nums.length;
            len--;
            return true;
        } else return false;
    }
    
    public int Front() {
        return isEmpty()? -1:nums[front];
    }
    public int Rear() {
        return isEmpty()? -1:nums[rear];
    }
    public boolean isEmpty() {
        return len==0;
    }
    public boolean isFull() {
        return len==nums.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */