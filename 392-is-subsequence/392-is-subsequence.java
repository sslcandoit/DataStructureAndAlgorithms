class Solution {
    /*
    public boolean isSubsequence(String s, String t) {
        int p1=0, p2=0, n1=s.length(), n2=t.length();
        while(p1<n1 && p2<n2){
            if(s.charAt(p1)==t.charAt(p2)){
                p1++;
                p2++;
            }else p2++;
        }
        return p1==n1;
    }
    */
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] count=new List[26];
        int len=t.length(), n=s.length();
        for(int i=0; i<len; i++){
            int index=t.charAt(i)-'a';
            if(count[index]==null) count[index]=new ArrayList<>();
            count[index].add(i);
        }
        int preIndex=0;
        for(int i=0; i<n; i++){
            int index=s.charAt(i)-'a';
            if(count[index]==null) return false;
            int j=Collections.binarySearch(count[index], preIndex);
            if(j<0) j=-j-1;
            if(j==count[index].size()) return false;
            preIndex=count[index].get(j)+1;
        }
        return true;
    }
}