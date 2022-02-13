class MaxStack {
    TreeMap<Integer, List<Node>> map;
    Node head, tail;
    public MaxStack() {
        this.map=new TreeMap<>();
        this.head=new Node(-1, null, null);
        this.tail=new Node(-1, head, null);
        head.next=tail;
    }
    
    public void push(int x) {
        Node newNode=new Node(x, tail.prev, tail);
        tail.prev.next=tail.prev=newNode;
        
        if(!map.containsKey(x)) map.put(x, new ArrayList<>());
        map.get(x).add(newNode);
    }
    
    public int pop() {
        int val=tail.prev.val;
        
        tail.prev.prev.next=tail;
        tail.prev=tail.prev.prev;
        
        List<Node> l=map.get(val);
        l.remove(l.size()-1);
        if(l.isEmpty()) map.remove(val);
        return val;
    }
    
    public int top() {
        return this.tail.prev.val;
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int max=peekMax();
        
        List<Node> l=map.get(max);
        Node temp=l.remove(l.size()-1);
        if(l.isEmpty()) map.remove(max);
        
        temp.prev.next=temp.next;
        temp.next.prev=temp.prev;
        return max;
    }
    class Node{
        int val;
        Node prev, next;
        public Node(int val, Node prev, Node next){
            this.val=val;
            this.prev=prev;
            this.next=next;
        }
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */