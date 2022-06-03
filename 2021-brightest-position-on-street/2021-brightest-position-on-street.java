class Solution {
    public int brightestPosition(int[][] lights) {
        TreeMap<Integer, Integer> tree_map=new TreeMap<>();
        
        int start, end;
        for(int[] l:lights){
            start=l[0]-l[1];
            end=l[0]+l[1]+1;
            tree_map.put(start, tree_map.getOrDefault(start, 0)+1);
            tree_map.put(end, tree_map.getOrDefault(end, 0)-1);
        }
        
        int brightest=0, max_brightest=0, postion_max_brightest=0;
        for(Map.Entry<Integer,Integer> entry : tree_map.entrySet()){
            brightest+=entry.getValue();
            if(brightest>max_brightest){
                max_brightest=brightest;
                postion_max_brightest=entry.getKey();
            }
        }
        return postion_max_brightest;
    }
}