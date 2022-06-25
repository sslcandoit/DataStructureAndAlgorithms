class WordDictionary {
    class Node{
        Node[] nodes;
        boolean isWord;
        public Node(){
            this.nodes=new Node[26];
            this.isWord=false;
        }
    }
    Node root;
    public WordDictionary() {
        this.root=new Node();
    }
    
    public void addWord(String word) {
        int m=word.length(), i=0;
        Node cur=root;
        while(i<m){
            if(cur.nodes[word.charAt(i)-'a']==null) cur.nodes[word.charAt(i)-'a']=new Node();
            cur=cur.nodes[word.charAt(i)-'a'];
            i++;
        }
        cur.isWord=true;
    }
    
    public boolean search(String word) {
        return helper(word, this.root, 0);
    }
    private boolean helper(String s, Node cur, int i){
        if(cur==null) return false;
        if(i==s.length()) return cur.isWord;
        
        char c=s.charAt(i);
        if(c=='.'){
            for(Node temp:cur.nodes){
                if(helper(s, temp, i+1)) return true;
            }
            return false;
        }else return helper(s, cur.nodes[c-'a'], i+1);
    } 
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */