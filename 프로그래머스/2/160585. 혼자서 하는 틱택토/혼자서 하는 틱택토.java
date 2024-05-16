class Solution {
    int answer = 0;
    
    public int solution(String[] board) {
        
        char[][] tempBoard = new char[3][3];
        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3 ; j++)
                tempBoard[i][j] = '.';
        }
        
        dfs(0, board, tempBoard);
        
        return answer;
    }
    
    private void dfs(int depth, String[] board, char[][] tempBoard){
        if(isSame(board, tempBoard)){
            answer = 1;
            return;
        }
        
        if(isEnd(tempBoard))return;
        
        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3 ; j++){
                if(tempBoard[i][j] != '.')continue;
                
                if(depth % 2 == 0)tempBoard[i][j] = 'O';
                else tempBoard[i][j] = 'X';
                
                dfs(depth + 1, board, tempBoard);
                
                if(answer == 1)return;
                
                tempBoard[i][j] = '.';
            }
        }
    }
    
    private boolean isSame(String[] board, char[][] tempBoard){
        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3 ; j++){
                if(board[i].charAt(j) != tempBoard[i][j])
                    return false;
            }
        }
        
        return true;
    }
    
    private boolean isEnd(char[][] board){
        int cnt1 = 0, cnt2 = 0, cnt3 = 0, cnt4 = 0;
        
        for(int i=0 ; i<3 ; i++){
            cnt1 = cnt2 = 0;
            
            for(int j=0 ; j<2 ; j++){
                
                if(board[i][j] != '.' && board[i][j] == board[i][j+1]){
                    cnt1++;
                }
                
                if(board[j][i] != '.' && board[j][i] == board[j+1][i]){
                    cnt2++;
                }
                
                if(cnt1 == 2 || cnt2 == 2)break;
            }
            
            if(cnt1 == 2 || cnt2 == 2)break;
        }
        
        for(int i=0 ; i<2 ; i++){
            if(board[i][i] == board[i+1][i+1] && board[i][i] != '.')cnt3++;
            if(board[i][2 - i] == board[i+1][1 - i] && board[i][2 - i] != '.')cnt4++;
        }
        
        return cnt1 == 2 || cnt2 == 2 || cnt3 == 2 || cnt4 == 2;
    }
}