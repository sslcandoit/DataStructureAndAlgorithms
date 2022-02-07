class SnapshotArray {
    private TreeMap<Integer, Integer>[] array;
    private int snap_id;
    public SnapshotArray(int length) {
        array=new TreeMap[length];
        for(int i=0; i<length; i++){
            TreeMap<Integer, Integer> tm=new TreeMap<>();
            tm.put(0,0);
            array[i]=tm;
        }
        this.snap_id=0;
    }
    
    public void set(int index, int val) {
        array[index].put(this.snap_id, val);
    }
    
    public int snap() {
        return snap_id++;
    }
    
    public int get(int index, int snap_id) {
        return array[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */