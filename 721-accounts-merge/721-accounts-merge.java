class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
             /*
    [["John","john_newyork@mail.com","johnsmith@mail.com"],
    ["John","john00@mail.com","johnsmith@mail.com"],
    ["Mary","mary@mail.com"],
    ["John","johnnybravo@mail.com"]]
    */
        Map<String, String> owner=new HashMap<>();
        Map<String, String> father=new HashMap<>();
        for(List<String> a:accounts){
            String o=a.get(0);
            for(int i=1; i<a.size(); i++){
                String son=a.get(i);
                owner.put(son, o);
                father.put(son, son);
            }
        }
        for(List<String> a:accounts){
            String f=findFather(a.get(1), father);
            for(int i=2; i<a.size(); i++){
                father.put(findFather(a.get(i), father), f);
            }
        }
        
        Map<String, TreeSet<String>> union=new HashMap<>();
        for(List<String> a:accounts){
            for(int i=1; i<a.size(); i++){
                String f=findFather(a.get(i), father);
                if(!union.containsKey(f)) union.put(f, new TreeSet<>());
                union.get(f).add(a.get(i));
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(String key:union.keySet()){
            List<String> list=new ArrayList<>(union.get(key));
            list.add(0, owner.get(key));
            ans.add(list);
        }
        return ans;
    }
    
    private String findFather(String c, Map<String, String> father){
        return father.get(c)==c? c:findFather(father.get(c), father);
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    
    
    
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> a : accounts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        for (List<String> a : accounts) {
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++)
                parents.put(find(a.get(i), parents), p);
        }
    
        for(List<String> a : accounts) {
            String p = find(a.get(1), parents);
            if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
            for (int i = 1; i < a.size(); i++)
                unions.get(p).add(a.get(i));
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }
    private String find(String s, Map<String, String> p) {
        return p.get(s) == s ? s : find(p.get(s), p);
    }
   
}*/