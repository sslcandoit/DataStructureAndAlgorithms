class MyHashMap {
    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key=key;
            this.value=value;
            this.next=null;
        }
    }
    private int size;
    private static double loadFactor=0.75;
    private Node[] bucket;
    public MyHashMap() {
        this.size=0;
        this.bucket=new Node[16];
    }
    public void expend(){
        Node[] oldBucket=this.bucket;
        Node[] newBucket=new Node[bucket.length*2];
        this.bucket=newBucket;
        this.size=0;
        
        for(Node head:oldBucket){
            while(head !=null){
                put(head.key, head.value);
                head=head.next;
            }
        } 
    }
    
    public void put(int key, int value) {
        int index=key%bucket.length;
        Node head=bucket[index];
        while(head !=null && head.key !=key) head=head.next;
        
        if(head==null){//not contain this key
            Node newNode=new Node(key, value);
            newNode.next=bucket[index];
            bucket[index]=newNode;
            size++;
        }else head.value=value; //contain thi skey
        
        if(size>=bucket.length*loadFactor) expend();
    }
    
    public int get(int key) {
        int index=key%bucket.length;
        Node head=bucket[index];
        while(head !=null && head.key !=key) head=head.next;
        
        return head==null? -1:head.value;
    }
    
    public void remove(int key) {
        int index=key%bucket.length;
        Node head=bucket[index];
        Node dummy=new Node(-1, -1);
        dummy.next=head;
        Node cur=dummy;
        
        while(cur.next !=null && cur.next.key !=key) cur=cur.next;
        
        if(cur.next !=null && cur.next.key==key){
            cur.next=cur.next.next;
            size--;
        }
        bucket[index]=dummy.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */