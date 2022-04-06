class Solution {
    public int numTeams(int[] rating) {
        int size=rating.length;
        int ans=0;
        
        for(int i=1; i<size-1; i++){
            int leftSmaller=0, rightGreater=0, leftGreater=0, rightSmaller=0;
            for(int j=0; j<size; j++){
                if(rating[i]<rating[j]){
                    if(j<i) leftGreater++;
                    else rightGreater++;
                }else if(rating[j]<rating[i]){
                    if(j<i) leftSmaller++;
                    else rightSmaller++;
                }
            }
            ans+=leftSmaller*rightGreater+leftGreater*rightSmaller;
        }
        return ans;
    }
}