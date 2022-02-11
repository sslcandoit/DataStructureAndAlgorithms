class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len=tasks.length;
        
        int[] count=new int[26];
        for(char c:tasks) count[c-'A']++;
        
        Arrays.sort(count);
        
        int max_m=count[25]-1;
        int need=max_m*n;
        
        for(int i=24; i>=0 && count[i] !=0; i--){
            need-=Math.min(max_m, count[i]);
        }
        return need<=0? len:(len+need);
    }
}