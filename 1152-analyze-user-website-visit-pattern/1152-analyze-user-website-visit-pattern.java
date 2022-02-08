class Solution {
    class Obj{
        int time;
        String website;
        public Obj(int time, String website){
            this.time=time;
            this.website=website;
        }
    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Obj>> map=new HashMap<>();
        for(int i=0 ; i<username.length; i++){
            String name=username[i];
            if(!map.containsKey(name)) map.put(name, new ArrayList<>());
            map.get(name).add(new Obj(timestamp[i], website[i]));
        }
        Map<String, Integer> count=new HashMap<>();
        for(String key:map.keySet()){
            List<Obj> list=map.get(key);
            Collections.sort(list, (a, b)-> a.time-b.time);
            int size=list.size();
            if(size<3) continue;
            else if(size==3){
                String str=list.get(0).website+"-"+list.get(1).website+"-"+list.get(2).website;
                count.put(str, count.getOrDefault(str, 0)+1);
            }else{
                Set<String> set=new HashSet<>();
                for(int i=0; i<size-2; i++){
                    for(int j=i+1; j<size-1; j++){
                        for(int k=j+1; k<size; k++){
                            String s=list.get(i).website+"-"+list.get(j).website+"-"+list.get(k).website;
                            set.add(s);
                        }
                    }
                }
                set.forEach(e-> count.put(e, count.getOrDefault(e, 0)+1));
            }
        }
        int max=0;
        Map<Integer, List<String>> ans=new HashMap<>();
        for(Map.Entry<String, Integer> e:count.entrySet()){
            int n=e.getValue();
            if(n>max) max=n;
            if(!ans.containsKey(n)) ans.put(n, new ArrayList<>());
            ans.get(n).add(e.getKey());
        }
        List<String> ans1=ans.get(max);
        Collections.sort(ans1);
        String ans2=ans1.get(0);
        String[] ans3=ans2.split("-");
        return Arrays.asList(ans3);
    }
}