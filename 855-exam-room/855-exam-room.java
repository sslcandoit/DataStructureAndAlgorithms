class ExamRoom {
    List<Integer> seats=new ArrayList<>();
    int n;
    public ExamRoom(int n) {
        this.n=n;
    }
    
    public int seat() {
        if(this.seats.size()==0){
            this.seats.add(0);
            return 0;
        }
        int d=Math.max(this.seats.get(0), this.n-1-this.seats.get(this.seats.size()-1));
        
        for(int i=0; i<seats.size()-1; i++){
            d=Math.max(d, (seats.get(i+1)-seats.get(i))/2);
        }
        if(seats.get(0)==d){
            seats.add(0, 0);
            return 0;
        }
        for(int i=0; i<seats.size()-1; i++){
            if((seats.get(i+1)-seats.get(i))/2==d){
                seats.add(i+1, seats.get(i)+d);
                return seats.get(i+1);
            }
        }
        seats.add(this.n-1);
        return this.n-1;
    }
    
    public void leave(int p) {
        for(int i=0; i<seats.size(); i++){
            if(seats.get(i)==p){
                seats.remove(i);
                return;
            }
        }
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
//[9]