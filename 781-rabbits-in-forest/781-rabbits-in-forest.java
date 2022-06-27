class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap();
        int res = 0;
        for(int num:answers){
            map.put(num, map.getOrDefault(num,0)+1);
            if(map.get(num)==1) res += num+1;
            if(map.get(num)>num) map.remove(num);//[1,0,1,0,0]
        }
        return res;
    }
}