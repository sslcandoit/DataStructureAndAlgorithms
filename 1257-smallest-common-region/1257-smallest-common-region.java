class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> parent=new HashMap<>();
        for(List<String> r:regions){
            String p=r.get(0);
            for(int i=1; i<r.size(); i++){
                parent.put(r.get(i), p);
            }
        }
        
        Set<String> ancestor=new HashSet<>();
        while(region1 !=null){
            ancestor.add(region1);
            region1=parent.get(region1);
        }
        
        while(!ancestor.contains(region2)){
            region2=parent.get(region2);
        }
        
        return region2;
    }
}