class Solution {
    public int solution(String[] board) {
        int answer = -1;
        char[][] temp = {{'.','.','.'},{'.','.','.'},{'.','.','.'}};
        return dfs(0, board, temp);
    }
    
    private int dfs(int depth, String[] board, char[][] temp){
        if(correctBoard(board, temp)){
            return 1;
        }
        
        if(gameOver(temp))
            return 0;
        
        if(depth == 9){
            return 0;
        }
        
        char shape = 'O';
        if(depth % 2 == 1)shape = 'X';
        
        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3; j++){
                if(temp[i][j] != '.')
                    continue;
                
                temp[i][j] = shape;
                if(dfs(depth + 1, board, temp) == 1){
                    return 1;
                }
                temp[i][j] = '.';
            }
        }
        
        return 0;
    }
    
    private boolean gameOver(char[][] temp){
        for(int i=0 ; i<3 ; i++){
            char shape = temp[i][0];
            int count = 0;
            
            if(shape == '.')
                continue;
            
            for(int j=0 ; j<3 ; j++){
                if(shape != temp[i][j])
                    break;
                
                count++;
            }
            
            if(count == 3)
                return true;
        }
        
        for(int j=0 ; j<3 ; j++){
            char shape = temp[0][j];
            int count = 0;
            
            if(shape == '.')
                continue;
            
            for(int i=0 ; i<3 ; i++){
                if(shape != temp[i][j])
                    break;
                
                count++;
            }
            
            if(count == 3)
                return true;
        }
        
        if(temp[0][0] != '.' && temp[0][0] == temp[1][1] && temp[1][1] == temp[2][2])
            return true;
        
        if(temp[0][2] != '.' && temp[0][2] == temp[1][1] && temp[1][1] == temp[2][0])
            return true;
        
        return false;
    }
    
    private boolean correctBoard(String[] board, char[][] temp){
        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3 ; j++){
                if(board[i].charAt(j) == temp[i][j])
                    continue;
                
                return false;
            }
        }
        
        return true;
    }
}