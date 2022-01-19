class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int rowStart=0, rowEnd=matrix.length-1;
        int colStart=0, colEnd=matrix[0].length-1;
        
        while(rowStart<=rowEnd && colStart<=colEnd){
            //go right
            for(int j=colStart; j<=colEnd; j++) ans.add(matrix[rowStart][j]);
            rowStart++;
            
            //go down
            for(int i=rowStart; i<=rowEnd; i++) ans.add(matrix[i][colEnd]);
            colEnd--;
        
            //go left
            if(rowStart<=rowEnd){
                for(int j=colEnd; j>=colStart; j--) ans.add(matrix[rowEnd][j]);
                rowEnd--;
            }
            
            //go up
            if(colStart<=colEnd){
                for(int i=rowEnd; i>=rowStart; i--) ans.add(matrix[i][colStart]);
                    colStart++;
            }
        }
        return ans;
    }
}