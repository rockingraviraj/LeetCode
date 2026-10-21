class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int arr[] = new int[2];
        boolean visit[][] = new boolean[m][n];
        Solve(0,0,grid,visit,arr);
        
       
        return arr;
        
        
    }
    private boolean Check(int row,int col,boolean[][] visit,char[][] grid){
        int r = row;
        int c = col;
        if(r<0 || r>=visit.length || c<0 || c>=visit[0].length){
            return true;
        }
        if(visit[r][c] == true){
            return true;
        }
        return false;
    }
    private void Solve(int row,int col,char[][] grid,boolean[][] visit,int[] arr){
        if(row < 0 || row>=grid.length || col<0 ||col>=grid[0].length){
            return;
        }
        if(visit[row][col]){
            return;
        }
        visit[row][col] = true;
        arr[0] = row;
        arr[1] = col;
        if(grid[row][col] == 'L'){
            if(Check(row,col-1,visit,grid) == false){
                Solve(row,col-1,grid,visit,arr);
            }
        }
        else if(grid[row][col] == 'R'){
            if(Check(row,col+1,visit,grid) == false){
                Solve(row,col+1,grid,visit,arr);
            }
        }
        else if(grid[row][col] == 'U'){
            if(Check(row-1,col,visit,grid) == false){
                Solve(row-1,col,grid,visit,arr);
            }
        }
        else if(grid[row][col] == 'D'){
            if(Check(row+1,col,visit,grid) == false){
                Solve(row+1,col,grid,visit,arr);
            }
        }
        
    }
}