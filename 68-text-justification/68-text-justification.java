class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans=new ArrayList<>();
        int left=0, m=words.length;
        while(left<m){
            int right=left+1, sumLen=words[left].length(), numSpace=0;
            while(right<m && sumLen+numSpace+1+words[right].length()<=maxWidth){
                sumLen+=words[right++].length();
                numSpace++;
            } 
            
            StringBuilder sb=new StringBuilder();
            
            boolean isLastLine= right==m;
            
            if(numSpace !=0){
                String evenSpace=" ".repeat((maxWidth-sumLen)/numSpace);
                int remainSpace=(maxWidth-sumLen)%numSpace;
            
                for(int i=left; i<right; i++){
                    sb.append(words[i]);
                    if(!isLastLine && i !=right-1){
                        sb.append(evenSpace);
                        if(remainSpace-- >0) sb.append(" ");
                    }
                    if(isLastLine && i !=right-1) sb.append(" ");
                }
            }else{
                sb.append(words[left]);
            }
            
            if(isLastLine || numSpace==0) sb.append(" ".repeat(maxWidth-sb.length()));
                
            ans.add(sb.toString());
            
            left=right;
        }
        return ans;
    }
}