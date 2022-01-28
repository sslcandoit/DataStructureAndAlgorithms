class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map=new HashMap<>();
        
        for(String str:paths){
            String[] temp=str.split(" ");
            String head=temp[0];
            for(int i=1; i<temp.length; i++){
                String s=temp[i];
                
                int index=s.indexOf('(');
                
                String tail=s.substring(0, index);
                String content=s.substring(index, s.length()-1);
                
                if(!map.containsKey(content)) map.put(content, new ArrayList<>());
                map.get(content).add(head+"/"+tail);
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(String k: map.keySet()){
            List<String> cur=map.get(k);
            if(cur.size()>1) ans.add(cur);
        }
        return ans;
    }
}