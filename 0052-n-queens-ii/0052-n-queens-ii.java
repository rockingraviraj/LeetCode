class Solution {
    public int totalNQueens(int n) {
        char map[][] = new char[n][n];
        for(int i =0;i<n;i++){
            Arrays.fill(map[i],'.');
        }
        List<List<String>> ans = new ArrayList<>();
        // hum har column main ek ek karke har row par Q rakhenge then check karenge
        int col = 0;
        
        Solve(n,map,ans,col);
        return ans.size();

        
    }
    public static boolean SafePlace(char[][] map,int row,int col,int n){
        int r = row;
        int c = col;

        // HoriZontal Left Chech
        while(c>=0){
            if(map[r][c] == 'Q'){
                return false;
            }
            c--;
        }
        // left upper Diagonal
        r = row;
        c = col;
        while(r>=0 && c>=0){
            if(map[r][c] == 'Q'){
                return false;
            }
            c--;
            r--;
        }
        // Left Lower Diagonal
        r = row;
        c = col;
        while(r<n && c>=0){
            if(map[r][c] == 'Q'){
                return false;
            }
            r++;
            c--;
        }
        return true;

    }
    public static void Solve(int n ,char[][] map , List<List<String>> ans,int col){
        if(col >= n){
            List<String> tem = new ArrayList<>();
            for(int i =0;i<n;i++){
                tem.add(new String(map[i]));
            }
            ans.add(tem);

        return;
        }
        for(int row = 0;row<n;row++){
            if(SafePlace(map,row,col,n)){
                map[row][col] = 'Q';
                // recursion call
                Solve(n,map,ans,col+1);
            }
            //back
            map[row][col] = '.';
        }    

    }
        
    }
