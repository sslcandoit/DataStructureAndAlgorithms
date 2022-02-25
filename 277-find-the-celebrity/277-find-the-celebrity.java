/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int ans=0;
        for(int i=1; i<n; i++){
            if(knows(ans, i)) ans=i;
        }
        for(int i=0; i<n; i++){
            if(ans !=i && (knows(ans, i) ||!knows(i, ans))) return -1;
        }
        return ans;
        /*
        for(int i=0; i<n; i++){
            int j;
            for(j=0; j<n; j++){
                if(j!=i && !knows(j, i)) break;
                if(j!=i && knows(i, j)) break;
            }
            if(j==n) return i;
        }
        return -1;
        */
    }
}