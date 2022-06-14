class MyCalendar {
    TreeMap<Integer, Integer> booked;
    public MyCalendar() {
        this.booked=new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floor=this.booked.floorEntry(start);
        Map.Entry<Integer, Integer> ceil=this.booked.ceilingEntry(start);
        if(floor !=null && floor.getValue()>start) return false;
        if(ceil !=null && ceil.getKey()<end) return false;
        this.booked.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

/*
   floor      ceiling
... |----| ... |----| ...
       |---------|
      s         e
if s < floor.end or e > ceiling.start, there is an overlap.

Another way to think of it:
If there is an interval start within the new book (must be the ceilingEntry) at all, or
books: |----|   |--|
            s |------| e

books: |----|   |----|
            s |----| e
If the new book start within an interval (must be the floorEntry) at all
books: |-------|   |--|
       s |---| e

books: |----|   |----|
        s |----| e
There is a overlap 
*/