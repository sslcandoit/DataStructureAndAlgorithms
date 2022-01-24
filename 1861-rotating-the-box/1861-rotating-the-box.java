class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m=box.length;
        int n=box[0].length;
        char[][] ans=new char[n][m];
        
        int i, j;
        int stone=0;
        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                ans[j][m-i-1]='.';
                if(box[i][j]=='#') stone++;
                else if(box[i][j]=='*'){
                    ans[j][m-i-1]='*';
                    int k=j;
                    while(stone !=0){
                        ans[k-1][m-i-1]='#';
                        k--;
                        stone--;
                    }
                }
            }
            while(stone !=0){
                ans[j-1][m-i-1]='#';
                j--;
                stone--;
            }
        }
        return ans;
    }
}