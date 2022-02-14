/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long l=1;
        long r=(long)n+1;
        while(l<r){
            long m=l+(r-l)/2;
            if(isBadVersion((int)m)) r=m;
            else l=m+1;
        }
        return (int)l;
        /*
        int l=1;
        int r=n;
        while(l<r){
            int mid=l+(r-l)/2;
            if(isBadVersion(mid)) r=mid;
            else l=mid+1;
        }
        return l;
        */
    }
}