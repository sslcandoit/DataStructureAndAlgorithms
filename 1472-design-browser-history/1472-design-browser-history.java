class BrowserHistory {
    class Node{
        Node pre, next;
        String url;
        public Node(String url, Node pre, Node next){
            this.pre=pre;
            this.next=next;
            this.url=url;
        }
    }
    private Node cur;
    public BrowserHistory(String homepage) {
        this.cur=new Node(homepage, null, null);
    }
    
    public void visit(String url) {
        Node newNode=new Node(url, cur, null);
        cur.next=newNode;
        cur=newNode;
    }
    
    public String back(int steps) {
        while(cur.pre !=null && steps !=0){
            this.cur=cur.pre;
            steps--;
        }
        return cur.url;
    }
    
    public String forward(int steps) {
        while(cur.next !=null && steps !=0){
            this.cur=cur.next;
            steps--;
        }
        return cur.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */