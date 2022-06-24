class MyHashSet {
    class TreeNode{
        TreeNode left, right;
        int val;
        public TreeNode(int val){
            this.val=val;
        }
    }
    private TreeNode[] roots;
    
    public MyHashSet() {
        roots=new TreeNode[251];
    }
    
    public void add(int key) {
        int i=key%251;
        if(this.roots[i]==null) this.roots[i]=new TreeNode(key);
        else{
            TreeNode cur=this.roots[i];
            while(cur !=null){
                if(key==cur.val) return;
                else if(key<cur.val){
                    if(cur.left!=null) cur=cur.left;
                    else{
                        TreeNode l=new TreeNode(key);
                        cur.left=l;
                        return;
                    } 
                }else{
                    if(cur.right !=null) cur=cur.right;
                    else{
                        TreeNode r=new TreeNode(key);
                        cur.right=r;
                        return;
                    }
                } 
            }
        }   
    }
    
    public void remove(int key) {
        int i=key%251;
        this.roots[i]=delete(this.roots[i], key);
    }
    private TreeNode delete(TreeNode root, int key){
        if(root==null) return null;
        if(key<root.val) root.left=delete(root.left, key);
        else if(key>root.val) root.right=delete(root.right, key);
        else{
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
        
            TreeNode rMin=root.right;
            while(rMin.left !=null) rMin=rMin.left;
            root.val=rMin.val;
            root.right=delete(root.right, root.val);
        }
        return root;
    }
    
    public boolean contains(int key) {
        int i=key%251;
        if(this.roots[i]==null) return false;
        else{
            TreeNode cur=this.roots[i];
            while(cur!=null){
                if(cur.val==key) return true;
                else if(key<cur.val) cur=cur.left;
                else cur=cur.right;
            }
        }
        return false;
    }
    
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */