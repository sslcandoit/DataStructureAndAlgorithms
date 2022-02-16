class Solution {
    Random rd;
    int[] w;
    public Solution(int[] w) {
        this.rd=new Random();
        for(int i=1; i<w.length; i++) w[i]+=w[i-1];
        this.w=w;
    }
    
    public int pickIndex() {
        int num=rd.nextInt(this.w[w.length-1])+1;
        int l=0, r=w.length;
        while(l<r){
            int m=l+(r-l)/2;
            if(this.w[m]==num) return m;
            else if(this.w[m]>num) r=m;
            else l=m+1;
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */