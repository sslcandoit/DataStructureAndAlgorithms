class Solution {
    public int totalFruit(int[] fruits) {
        int m=fruits.length;
        Map<Integer, Integer> map=new HashMap<>();
        int max=0;
        for(int l=0, r=0; r<m; r++){
            int cur=fruits[r];
            map.put(cur, map.getOrDefault(cur, 0)+1);
            while(map.size()>2){
                map.put(fruits[l], map.get(fruits[l])-1);
                if(map.get(fruits[l])==0) map.remove(fruits[l]);
                l++;
            }
            max=Math.max(max, r-l+1);
        }
        return max;
    }
}