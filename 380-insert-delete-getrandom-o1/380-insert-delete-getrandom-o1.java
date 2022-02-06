class RandomizedSet {
    private List<Integer> list;
    public RandomizedSet() {
        this.list=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(list.contains(val)) return false;
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!list.contains(val)) return false;
        int i=list.indexOf(val);
        int j=list.size()-1;
        list.set(i, list.get(j));
        list.remove(j);
        return true;
    }
    
    public int getRandom() {
        int index=(int)(Math.random()*list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */