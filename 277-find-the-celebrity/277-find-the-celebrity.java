/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        for(int i=0; i<n; i++){
            int j;
            for(j=0; j<n; j++){
                if(j!=i && !knows(j, i)) break;
                if(j!=i && knows(i, j)) break;
            }
            if(j==n) return i;
        }
        return -1;
    }
}