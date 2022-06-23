class Solution {
    public boolean canTransform(String start, String end) {
        int n=start.length();
        int p1=0, p2=0;
        
        while(p1<n || p2<n){
            while(p1<n && start.charAt(p1)=='X') p1++;
            while(p2<n && end.charAt(p2)=='X') p2++;
            
            if(p1==n && p2==n) return true;
            if(p1==n || p2==n) return false;
            
            if(start.charAt(p1) !=end.charAt(p2)) return false;
            
            if(start.charAt(p1)=='L' && p2>p1) return false;
            if(start.charAt(p1)=='R' && p1>p2) return false;
            
            p1++;
            p2++;
        }
        return true;
    }
}