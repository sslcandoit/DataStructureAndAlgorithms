// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> ite=null;
    Integer next=null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.ite=iterator;
        if(hasNext()) this.next=this.ite.next();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return this.next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer cur=this.next;
        if(ite.hasNext()) this.next=this.ite.next();
        else this.next=null;
        return cur;
	}
	
	@Override
	public boolean hasNext() {
	    return this.next !=null || this.ite.hasNext();
	}
}