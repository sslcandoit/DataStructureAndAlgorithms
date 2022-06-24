class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int m=transactions.length;
        List<String> ans=new ArrayList<>();
        boolean[] added=new boolean[m];
            
        for(int i=0; i<m; i++){
            String[] info=transactions[i].split(",");
            if(!added[i] && Integer.parseInt(info[2])>1000){
                ans.add(transactions[i]);
                added[i]=true;
            } 
            for(int j=i+1; j<m; j++){
                String[] info1=transactions[j].split(",");
                
                if(info[0].equals(info1[0]) 
                   && !info[3].equals(info1[3]) 
                   && Math.abs(Integer.parseInt(info[1])-Integer.parseInt(info1[1]))<=60){
                    if(!added[i]){
                        ans.add(transactions[i]);
                        added[i]=true;
                    } 
                    if(!added[j]){
                        ans.add(transactions[j]);
                        added[j]=true;
                    } 
                }
            }
        }
        return ans;
    }
}