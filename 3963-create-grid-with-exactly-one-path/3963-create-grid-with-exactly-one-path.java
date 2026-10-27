class Solution {
    public String[] createGrid(int m, int n) {
        char grid[][] = new char[m][n];
      
        for(int i = 0;i<m;i++){
            grid[i][0] ='.';
        }
        for(int j = 0;j<n;j++){
            grid[m-1][j] = '.';
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == '.'){
                    continue;
                }
                else{
                    grid[i][j] = '#';
                }
            }
        }
          String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            ans[i] = new String(grid[i]);
        }
        return ans;
        
    }
  
}