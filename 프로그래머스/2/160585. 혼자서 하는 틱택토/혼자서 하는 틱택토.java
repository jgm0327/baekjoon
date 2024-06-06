class Solution {
    int answer = 0;
    public int solution(String[] board) {
        char[][] pattern = {{'.','.','.'},{'.','.','.'},{'.','.','.'}};
        
        dfs(0, pattern, board);
        return answer;
    }
    
    private boolean isOver(char[][] pattern){
        
        for(int i=0 ; i<3 ; i++){
            int oCnt1 = 0, xCnt1 = 0, oCnt2 = 0, xCnt2 = 0;
            
            for(int j=0 ; j<3 ; j++){
                char shape1 = pattern[i][j];
                char shape2 = pattern[j][i];
                
                if(shape1 == 'O')oCnt1++;
                else if(shape1 == 'X')xCnt1++;
                
                if(shape2 == 'O')oCnt2++;
                else if(shape2 == 'X')xCnt2++;
            }
            
            if(oCnt1 == 3 || xCnt2 == 3 || xCnt1 == 3 || oCnt2 == 3)
                return true;
        }
        
        int oCnt1 = 0, xCnt1 = 0, oCnt2 = 0, xCnt2 = 0;
            for(int i=0 ; i<3 ; i++){
                char shape1 = pattern[i][i];
                char shape2 = pattern[i][2 - i];
                
                if(shape1 == 'O')oCnt1++;
                else if(shape1 == 'X')xCnt1++;
                
                if(shape2 == 'O')oCnt2++;
                else if(shape2 == 'X')xCnt2++;
            }
        
        
            if(oCnt1 == 3 || xCnt2 == 3 || xCnt1 == 3 || oCnt2 == 3)
                return true;
        
        return false;
    }
    
    private void dfs(int depth, char[][] pattern, final String[] board){
        if(check(board, pattern)){
            answer = 1;
            return;
        }
        
        if(isOver(pattern))
            return;
        
        char shape = 'O';
        if(depth % 2 == 1)
            shape = 'X';
        
        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3 ; j++){
                if(pattern[i][j] != '.')
                    continue;
                
                pattern[i][j] = shape;
                
                dfs(depth + 1, pattern, board);
                if(answer == 1)return;
                
                pattern[i][j] = '.';
            }
        }
    }
    
    private boolean check(String[] board, char[][] pattern){
        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3 ; j++){
                if(board[i].charAt(j) != pattern[i][j])
                    return false;
            }
        }
        
        return true;
    }
}