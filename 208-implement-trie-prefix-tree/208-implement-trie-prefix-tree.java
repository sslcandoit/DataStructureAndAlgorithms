class Trie {
    public class TrieTree{
        TrieTree[] kids;
        boolean isWord;
        public TrieTree(){
            this.kids=new TrieTree[26];
            this.isWord=false;
        }
    }
    private TrieTree root;
    public Trie() {
        this.root=new TrieTree();
    }
    
    public void insert(String word) {
        TrieTree cur=root;
        for(int i=0; i<word.length(); i++){
            int j=word.charAt(i)-'a';
            if(cur.kids[j]==null) cur.kids[j]=new TrieTree();
            cur=cur.kids[j];
        }
        cur.isWord=true;
    }
    
    public boolean search(String word) {
        TrieTree cur=root;
        for(int i=0; i<word.length(); i++){
            int j=word.charAt(i)-'a';
            if(cur.kids[j]==null) return false;
            cur=cur.kids[j];
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieTree cur=root;
        for(int i=0; i<prefix.length(); i++){
            int j=prefix.charAt(i)-'a';
            if(cur.kids[j]==null) return false;
            cur=cur.kids[j];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */