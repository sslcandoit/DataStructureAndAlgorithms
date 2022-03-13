class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>(wordList);
        Queue<String> q=new ArrayDeque<>();
        q.offer(beginWord);
        int level=1;
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                String cur=q.poll();
                char[] ch=cur.toCharArray();
                for(int j=0; j<ch.length; j++){
                    char old=ch[j];
                    for(char x='a'; x<='z'; x++){
                        ch[j]=x;
                        String temp=new String(ch);
                        if(set.contains(temp)){
                            if(temp.equals(endWord)) return level+1;
                            set.remove(temp);
                            q.offer(temp);
                        }
                    }
                    ch[j]=old;
                }
            }
            level++;
        }
        return 0;
    }
}