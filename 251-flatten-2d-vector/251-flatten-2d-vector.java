class Vector2D {
    int[][] v;
    int i=0, j=0;
    public Vector2D(int[][] vec) {
        this.v=vec;
    }
    
    public int next() {
        hasNext();
        return v[i][j++];
    }
    
    public boolean hasNext() {
        while(i<v.length && j==v[i].length){
            i++;
            j=0;
        }
        return i<v.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */