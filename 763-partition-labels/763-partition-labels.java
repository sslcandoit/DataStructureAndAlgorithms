class Solution {
    public List<Integer> partitionLabels(String s) {
        int m=s.length();
        int[] index=new int[26];
        for(int i=0; i<m; i++){
            index[s.charAt(i)-'a']=i;
        }
        List<Integer> ans=new ArrayList<>();
        
        int left=0, right=0;
        for(int i=0; i<m; i++){
            right=Math.max(right, index[s.charAt(i)-'a']);
            if(right==i){
                ans.add(right-left+1);
                left=i+1;
            }
        }
        return ans;
    }
}