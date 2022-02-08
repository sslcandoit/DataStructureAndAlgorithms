class Solution {
    
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map=new HashMap<>();
        for(int i=0; i<keyName.length; i++){
            String name=keyName[i];
            if(!map.containsKey(name)) map.put(name, new ArrayList<>());
            String t=keyTime[i];
            int time=Integer.parseInt(t.substring(0, 2))*60+Integer.parseInt(t.substring(3));
            map.get(name).add(time);
        }
        List<String> ans=new ArrayList<>();
        for(Map.Entry<String, List<Integer>> e: map.entrySet()){
            List<Integer> temp=e.getValue();
            Collections.sort(temp);
            for(int i=2; i<temp.size(); i++){
                if(temp.get(i)-temp.get(i-2)<=60){
                    ans.add(e.getKey());
                    break;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}