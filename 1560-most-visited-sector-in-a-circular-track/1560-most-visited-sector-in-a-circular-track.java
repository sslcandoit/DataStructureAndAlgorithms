class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int s=rounds[0], e=rounds[rounds.length-1];
        List<Integer> list=new ArrayList<>();
        if(s<=e){
            while(s<=e) list.add(s++);
        }else{
            int i=1;
            while(i<=e) list.add(i++);
            while(s<=n) list.add(s++);
        }
        return list;
    }
    /*
         s---------
    ---------------
    ---------------
    ----------e
    
             s-----
    ---------------
    ---------------
    -----e
    
    */
}