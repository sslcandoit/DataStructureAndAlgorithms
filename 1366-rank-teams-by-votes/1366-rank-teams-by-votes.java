class Solution {
    class Node{
        char ch;
        int[] count;
        public Node(char ch){
            this.ch=ch;
            this.count=new int[26];
        }
    }
    public String rankTeams(String[] votes) {
        int m=votes.length;
        if(m==1) return votes[0];
        
        Node[] teams=new Node[26];
        for(int i=0; i<26; i++) teams[i]=new Node((char)(i+'A'));
        
        for(String vote:votes){
            for(int i=0; i<vote.length(); i++){
                Node team=teams[vote.charAt(i)-'A'];
                team.count[i]++;
            }
        }
        Arrays.sort(teams, new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                for(int i=0; i<26; i++){
                    if(a.count[i] !=b.count[i]) return b.count[i]-a.count[i];
                }
                return a.ch-b.ch;
            }
        });
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<votes[0].length(); i++) sb.append(teams[i].ch);
        
        return sb.toString();
    }
}