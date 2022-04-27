class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m=mat.length, n=mat[0].length;
        Map<Integer, PriorityQueue<Integer>> map=new HashMap<>();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int diff=i-j;
                if(!map.containsKey(diff)) map.put(diff, new PriorityQueue<>());
                map.get(diff).offer(mat[i][j]);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int diff=i-j;
                mat[i][j]=map.get(diff).poll();
            }
        }
        return mat;
    }
}