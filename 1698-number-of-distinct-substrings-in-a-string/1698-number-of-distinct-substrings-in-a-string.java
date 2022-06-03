class Solution {
    public int countDistinct(String s) {
        int len=s.length();
        int ans=0;
        Set<String> set=new HashSet<>();
        
        for(int i=1; i<=len; i++){
            for(int j=0; j+i<=len; j++){
                set.add(s.substring(j, j+i));
            }
        }
        return set.size();
    }
}
/*class Node {
    Node[] children = new Node[26];
}

class Solution {
    public int countDistinct(String s) {
        Node root = new Node();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Node cur = root;
            for (int j = i; j < s.length(); j++) {
                if (cur.children[s.charAt(j) - 'a'] == null) {
                    cur.children[s.charAt(j) - 'a'] = new Node();
                    res++;
                }
                cur = cur.children[s.charAt(j) - 'a'];
            }
        }
        return res;
    }
}
*/