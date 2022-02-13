class LRUCache {
    class Node{
        int key, value;
        Node pre, next;
        public Node(int key, int value, Node pre, Node next){
            this.key=key;
            this.value=value;
            this.pre=pre;
            this.next=next;
        }
    }
    private Map<Integer, Node> map;
    private Node head, tail;
    private int capacity;
    
    public LRUCache(int capacity) {
        this.map=new HashMap<>();
        this.head=new Node(-1, -1, null, null);
        this.tail=new Node(-1, -1, head, null);
        this.head.next=tail;
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        
        Node temp=map.get(key);
        temp.pre.next=temp.next;
        temp.next.pre=temp.pre;
        
        Node newNode=new Node(key, temp.value, tail.pre, tail);
        tail.pre.next=newNode;
        tail.pre=newNode;
        
        map.put(key, newNode);
        return newNode.value;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            Node newNode = new Node(key, value, tail.pre, tail);
            tail.pre.next=newNode;
            tail.pre=newNode;
            map.put(key, newNode);
            if(map.size()>this.capacity){
                Node temp=head.next;
                temp.pre.next=temp.next;
                temp.next.pre=temp.pre;
                map.remove(temp.key);
            }
        }else{
            Node temp=map.get(key);
            temp.pre.next=temp.next;
            temp.next.pre=temp.pre;
        
            Node newNode=new Node(key, value, tail.pre, tail);
            tail.pre.next=newNode;
            tail.pre=newNode;
        
            map.put(key, newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */