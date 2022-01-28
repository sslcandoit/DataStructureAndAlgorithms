class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans=0;
        List<String> list=new ArrayList<>();
        int l=0, r=0;
        while(r<s.length()){
            if(s.charAt(r) !=s.charAt(l)){
                list.add(s.substring(l, r));
                l=r;
            } 
            r++;
        }
        list.add(s.substring(l, r));
    
        for(int i=0; i<words.length; i++){
            List<String> ll=new ArrayList<>();
            l=0;
            r=0;
            String w=words[i];
            while(r<w.length()){
                if(w.charAt(r) !=w.charAt(l)){
                    ll.add(w.substring(l, r));
                    l=r;
                } 
                r++;
            }
            ll.add(w.substring(l, r));
            if(list.size() !=ll.size()) continue;
            for(int j=0; j<list.size(); j++){
                String s1=list.get(j), s2=ll.get(j);
                int len1=s1.length(), len2=s2.length();
                if(s1.charAt(0) !=s2.charAt(0) || len2>len1 || (len1 !=len2 && len1<3) ) break;
                if(j==list.size()-1) ans++;
            }
        }
        return ans;
    }
}