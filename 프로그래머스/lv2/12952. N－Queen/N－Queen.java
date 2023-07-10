class Solution {
    private int answer = 0;
    private char[][] board;
    private boolean[][] visit;
    
    public int solution(int n) {
        board = new char[n][n];
        visit = new boolean[n][n];
        recur(0, n);
        return answer;
    }
    
    private void recur(int depth, int n){
        if(depth == n){
            answer++;
            return;
        }
        
//         for(int i=start_y ; i<n ; i++){
//             if(i != start_y)start_x = 0;
//             for(int j=start_x ; j<n ; j++){
//                 if(visit[i][j] || !vertical(i, j, n) || !horizon(i, j, n) || !dialog(i, j, n))continue;
//                 board[i][j] = 'Q';
//                 visit[i][j] = true;
//                 recur(i, j, n, depth + 1);
//                 board[i][j] = 'E';
//                 visit[i][j] = false;
//             }
//         }
        
        for(int i=0 ; i<n ; i++){
            if(!vertical(depth, i, n) || !horizon(depth, i, n) || !dialog(depth, i, n))continue;
            board[depth][i] = 'Q';
            recur(depth+1, n);
            board[depth][i] = 'E';
        }
    }
    
    private boolean vertical(int y, int x, int n){
        for(int i=0 ; i<n ; i++){
            if(board[i][x] != 'Q')continue;
            return false;
        }
        return true;
    }
    
    private boolean horizon(int y, int x, int n){
        for(int i=0 ; i<n ; i++){
            if(board[y][i] != 'Q')continue;
            return false;
        }
        return true;
    }
    
    private boolean isIn(int y, int x, int n){
        return 0 <= y && y < n && 0 <= x && x < n;
    }
    
    private boolean dialog(int y, int x, int n){
        for(int i=0 ; i<n ; i++){
            if((isIn(y + i, x + i, n) && board[y + i][x + i] == 'Q') 
               || (isIn(y - i, x - i, n) && board[y - i][x - i] == 'Q'))return false;
            if((isIn(y+i, x-i, n) && board[y+i][x-i] == 'Q') || (isIn(y-i, x+i, n) && board[y-i][x+i]=='Q'))return false;
        }
        return true;
    }
}