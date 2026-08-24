class Solution {
    public static boolean emptyCell(char[][] board ,int[] emptycell){
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j] == '.'){
                    emptycell[0] = i;
                    emptycell[1] = j;
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean Solve(char[][] board ){
        int emptycell[] = new int[2];
        if(!emptyCell(board,emptycell)){
            return true;
        }
        int rowindex = emptycell[0];
        int colindex = emptycell[1];

        for(int i = 1;i<=9;i++){
            char value = (char)(i +'0');
            if(IsSafeToPlace(board,rowindex,colindex,value)){
                board[rowindex][colindex] = value;
                if(Solve(board) == true){
                    return true;
                }
                // BackTracking
                board[rowindex][colindex] = '.';

            }

        }
        return false;
    } 
    public static boolean IsSafeToPlace(char[][] board,int rowindex,int colindex,char value){
        int row = rowindex - rowindex%3;
        int col = colindex - colindex %3;
       for(int i = row; i < row + 3; i++){
          for(int j = col; j < col + 3; j++){
        if(board[i][j] == value){
            return false;
             }
         }
       }
        

        for(int i = 0;i<9;i++){
            if(board[rowindex][i] == value){
                return false;
            }
        }

        for(int i =0;i<9;i++){
            if(board[i][colindex] == value){
                return false;
            }
        }

        return true;

    }
    public void solveSudoku(char[][] board) {
        Solve(board);
        
        
    }
}