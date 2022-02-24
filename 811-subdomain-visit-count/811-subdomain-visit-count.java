class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map=new HashMap<>();
        for(String s:cpdomains){
            int space=s.indexOf(" ");
            int freq=Integer.parseInt(s.substring(0, space));
            String domains=s.substring(space+1);
            
            while(domains !=null){
                map.put(domains, map.getOrDefault(domains, 0)+freq);
                int i=domains.indexOf(".");
                if(i !=-1){
                    domains=domains.substring(i+1);
                }else break;
            }
        }
        
        List<String> ans=new ArrayList<>();
        for(Map.Entry<String, Integer> e:map.entrySet()){
            ans.add(e.getValue()+" "+e.getKey());
        }
        return ans;
    }
}