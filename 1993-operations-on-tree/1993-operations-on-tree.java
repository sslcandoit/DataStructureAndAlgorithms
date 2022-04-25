class LockingTree {
    private int[] parent;
    private Map<Integer, Integer> locked;
    private List<Integer>[] children;
    public LockingTree(int[] parent) {
        this.parent=parent;
        this.locked=new HashMap<>();
        this.children=new List[parent.length];
        for(int i=1; i<children.length; i++){
            if(children[parent[i]]==null) children[parent[i]]=new ArrayList<>();
            children[parent[i]].add(i);
        }
    }
    public boolean lock(int num, int user) {
        if(locked.containsKey(num)) return false;
        locked.put(num, user);
        return true;
    }
    public boolean unlock(int num, int user) {
        if(!locked.containsKey(num) || locked.get(num) !=user) return false;
        locked.remove(num);
        return true;
    }
    public boolean upgrade(int num, int user) {
        if(locked.containsKey(num)) return false;
        
        int cur=num;
        while(cur !=-1){
            cur=parent[cur];
            if(locked.containsKey(cur)) return false;
        }
        int size=locked.size();
        dfs(num);
        if(locked.size()==size) return false;
        locked.put(num, user);
        return true;
    }
    private void dfs(int num){
        if(locked.containsKey(num)) locked.remove(num);
        if(children[num] !=null){
            for(int n:children[num]) dfs(n);
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */