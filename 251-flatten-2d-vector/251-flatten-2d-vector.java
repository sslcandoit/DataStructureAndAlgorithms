class Vector2D {
    List<Integer> list;
    int i;
    public Vector2D(int[][] vec) {
        this.list=new ArrayList<>();
        for(int i=0; i<vec.length; i++){
            for(int j=0; j<vec[i].length; j++){
                list.add(vec[i][j]);
            }
        }
        this.i=0;
    }
    
    public int next() {
        return this.list.get(i++);
    }
    
    public boolean hasNext() {
        return this.i<list.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */