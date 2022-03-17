class Solution {
    public boolean isReflected(int[][] points) {
        Set<String> set=new HashSet<>();
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(int[] p:points){
            set.add(p[0]+"#"+p[1]);
            min=Math.min(min, p[0]);
            max=Math.max(max, p[0]);
        }
        int sum=min+max;
        for(int[] p:points){
            if(!set.contains(sum-p[0]+"#"+p[1])) return false;
        }
        return true;
    }
}