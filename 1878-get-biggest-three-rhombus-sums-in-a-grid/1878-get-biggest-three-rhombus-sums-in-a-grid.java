class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        Set<Integer> set=new HashSet<>();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                set.add(grid[i][j]);
                
                int radius=Math.min(Math.min(i, j), m-i-1);
                radius=Math.min(radius, n-j-1);
                
                for(int r=1; r<=radius; r++){
                    int a=i-r, b=j, sum=0;
                    
                    for(int k=0; k<r; k++){
                        a++;
                        b++;
                        sum+=grid[a][b];
                    }
                    for(int k=0; k<r; k++){
                        a++;
                        b--;
                        sum+=grid[a][b];
                    }
                    for(int k=0; k<r; k++){
                        a--;
                        b--;
                        sum+=grid[a][b];
                    }
                    for(int k=0; k<r; k++){
                        a--;
                        b++;
                        sum+=grid[a][b];
                    }
                    set.add(sum);
                }
            }
        }
        return set.stream().sorted(Comparator.reverseOrder()).limit(3).mapToInt(Integer::intValue).toArray();
    }
}